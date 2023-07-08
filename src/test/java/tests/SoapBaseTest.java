package tests;

import org.testng.annotations.BeforeTest;
import utils.services.soap.CountryService;
import utils.services.soap.CurrencyService;

import java.io.IOException;

/**
 * This class serves as a base test class for SOAP API tests.
 * It sets up the necessary services and resources required for the tests.
 * The SoapBaseTest class initializes a CountryService object to interact with the SOAP country service
 * and a CurrencyService object to interact with the SOAP currency service.
 * In the setUpServices method, the CountryService and CurrencyService objects are instantiated and assigned to the country and currency variables, respectively.
 * Note: This class uses the TestNG framework for test execution.
 * The @BeforeTest annotation ensures that the setUpServices method is executed before any test methods.
 * The IOException is thrown if there is an error initializing the CountryService or CurrencyService objects.
 */
public class SoapBaseTest {

    public CountryService country;
    public CurrencyService currency;

    @BeforeTest
    public void setUpServices() throws IOException {
        country = new CountryService();
        currency = new CurrencyService();
    }
}
