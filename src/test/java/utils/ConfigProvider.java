package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    //Credentials
    String URL = readConfig().getString("url");
    String ACCESS_TOKEN = readConfig().getString("accessToken");

    static Config readConfig() {
        return ConfigFactory.load("testData.conf");
    }
}
