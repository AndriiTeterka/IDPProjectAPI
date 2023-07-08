package utils.services.soap;

import utils.ConfigProvider;
import utils.services.SoapService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * This class provides methods to interact with the SOAP API for currencies.
 * It extends the SoapService class.
 * The CurrencyService class is responsible for sending SOAP requests related to currencies.
 * It has a method to retrieve the currency name list.
 * Note: This class uses the ConfigProvider class to retrieve the file path for the SOAP request.
 * The SoapService class provides the base functionality for sending SOAP requests.
 * The REQUEST_SPECIFICATION is inherited from the SoapService class and is used for request specification.
 */
public class CurrencyService extends SoapService {

    String currencyNamesRequest = new String(Files.readAllBytes(Paths.get(ConfigProvider.CURRENCY_NAMES_FILE_PATH)));

    public CurrencyService() throws IOException {
    }

    @Override
    public String getBasePath() {
        return "/websamples.countryinfo/CountryInfoService.wso";
    }

    public List<String> getCurrencyNameList() {
        return Arrays.stream(given()
                        .spec(REQUEST_SPECIFICATION)
                        .body(currencyNamesRequest)
                        .post()
                        .andReturn()
                        .getBody()
                        .asString()
                        .replaceAll("<m:sISOCode>.*?</m:sISOCode>", "")
                        .replaceAll("<[^>]+>", "")
                        .replaceAll("\\s*\\n\\s*", "\n").trim()
                        .split("\n"))
                .toList();
    }
}
