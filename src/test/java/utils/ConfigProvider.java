package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    //Rest
    String URL = readConfig().getString("restUrl");
    String ACCESS_TOKEN = readConfig().getString("accessToken");

    //Soap
    String SOAP_URL = readConfig().getString("soapUrl");
    String COUNTRY_NAMES_FILE_PATH = readConfig().getString("countryNamesFilePath");
    String COUNTRY_CAPITALS_FILE_PATH = readConfig().getString("countryCapitalsFilePath");
    String COUNTRY_CURRENCIES_FILE_PATH = readConfig().getString("countryCurrenciesFilePath");
    String CURRENCY_NAMES_FILE_PATH = readConfig().getString("currencyNamesFilePath");


    static Config readConfig() {
        return ConfigFactory.load("testData.conf");
    }
}
