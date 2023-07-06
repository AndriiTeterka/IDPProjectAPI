package utils.services.soap;

import utils.ConfigProvider;
import utils.services.SoapService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

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
