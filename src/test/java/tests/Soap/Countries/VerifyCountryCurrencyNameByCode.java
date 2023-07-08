package tests.Soap.Countries;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.SoapBaseTest;

/**
 * This class contains a test case for verifying the currency name of a country by its country code using a SOAP request.
 * It extends the SoapBaseTest class.
 * The VerifyCountryCurrencyNameByCode test case uses the country object to retrieve the currency name of the country with code "UA",
 * and asserts that the currency name is equal to "Hryvnia".
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The assertThat method from the AssertJ library is used for assertions.
 */
public class VerifyCountryCurrencyNameByCode extends SoapBaseTest {

    @Description("Verify country currency name by country code")
    @Test(description = "Verify country currency name by country code")
    public void verifyCountryCurrencyNameByCode() {
        Assertions.assertThat(country.getCountryCurrencyNameByCode("UA"))
                .isEqualTo("Hryvnia")
                .as("Country currency and country code does not match");
    }
}
