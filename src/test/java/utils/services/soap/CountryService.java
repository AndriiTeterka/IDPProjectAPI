package utils.services.soap;

import utils.ConfigProvider;
import utils.services.SoapService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static io.restassured.RestAssured.given;

/**
 * This class provides methods to interact with the SOAP API for countries.
 * It extends the SoapService class.
 * The CountryService class is responsible for sending SOAP requests related to countries.
 * It has methods to retrieve the country name list, country code list,
 * country code and name map, country capital by country code, and country currency name by country code.
 * Note: This class uses the ConfigProvider class to retrieve file paths for SOAP requests.
 * The SoapService class provides the base functionality for sending SOAP requests.
 * The REQUEST_SPECIFICATION is inherited from the SoapService class and is used for request specification.
 * The HashMap is used to store the country code and name map.
 */
public class CountryService extends SoapService {

    String countryNamesRequest = new String(Files.readAllBytes(Paths.get(ConfigProvider.COUNTRY_NAMES_FILE_PATH)));
    String countryCapitalsRequest = new String(Files.readAllBytes(Paths.get(ConfigProvider.COUNTRY_CAPITALS_FILE_PATH)));
    String countryCurrenciesRequest = new String(Files.readAllBytes(Paths.get(ConfigProvider.COUNTRY_CURRENCIES_FILE_PATH)));


    public CountryService() throws IOException {
    }

    @Override
    public String getBasePath() {
        return "/websamples.countryinfo/CountryInfoService.wso";
    }

    public List<String> getCountryNameList() {
        String[] response = given()
                .spec(REQUEST_SPECIFICATION)
                .body(countryNamesRequest)
                .post()
                .andReturn()
                .getBody()
                .asString()
                .replaceAll("<m:sISOCode>.*?</m:sISOCode>", "")
                .replaceAll("<[^>]+>", "")
                .replaceAll("\\s*\\n\\s*", "\n").trim()
                .split("\n");

        List<String> list = new ArrayList<>(Arrays.asList(response));
        list.removeIf(country -> !country.matches("[a-zA-Z]+"));
        return list;
    }

    public List<String> getCountryCodeList() {
        String[] response = given()
                .spec(REQUEST_SPECIFICATION)
                .body(countryNamesRequest)
                .post()
                .andReturn()
                .getBody()
                .asString()
                .replaceAll("<m:sName>.*?</m:sName>", "")
                .replaceAll("<[^>]+>", "")
                .replaceAll("\\s*\\n\\s*", "\n").trim()
                .split("\n");

        return Arrays.asList(response);
    }

    public Map<String, String> getCountryCodeAndNameMap() {
        List<String> response = Arrays.stream(given()
                        .spec(REQUEST_SPECIFICATION)
                        .body(countryNamesRequest)
                        .post()
                        .andReturn()
                        .getBody()
                        .asString()
                        .replaceAll("<[^>]+>", "")
                        .replaceAll("\\s*\\n\\s*", "\n").trim()
                        .split("\n"))
                .toList();

        Map<String, String> countryCodeAndNameMap = new HashMap<>();

        for (int i = 0; i < response.size(); i += 2) {
            countryCodeAndNameMap.put(response.get(i), response.get(i + 1));
        }

        return countryCodeAndNameMap;
    }

    public String getCountryCapitalByCode(String countryCode) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(countryCapitalsRequest.replace("{countryCode}", countryCode))
                .post()
                .andReturn()
                .getBody()
                .asString()
                .replaceAll("<[^>]+>", "")
                .replaceAll("\\s*\\n\\s*", "").trim();
    }

    public String getCountryCurrencyNameByCode(String countryCode) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(countryCurrenciesRequest.replace("{countryCode}", countryCode))
                .post()
                .andReturn()
                .getBody()
                .asString()
                .replaceAll("<m:sISOCode>.*?</m:sISOCode>", "")
                .replaceAll("<[^>]+>", "")
                .replaceAll("\\s*\\n\\s*", "").trim();
    }
}
