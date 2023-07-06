package tests;

import org.testng.annotations.BeforeTest;
import utils.services.soap.CountryService;
import utils.services.soap.CurrencyService;

import java.io.IOException;

public class SoapBaseTest {

    public CountryService country;
    public CurrencyService currency;

    @BeforeTest
    public void setUpServices() throws IOException {
        country = new CountryService();
        currency = new CurrencyService();
    }
}
