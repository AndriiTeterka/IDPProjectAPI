package tests.Soap.Countries;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.SoapBaseTest;

/**
 * This class contains a test case for verifying the capital of a country by its country code using a SOAP request.
 * It extends the SoapBaseTest class.
 * The VerifyCountryCapitalByCode test case uses the country object to retrieve the capital of the country with code "UA",
 * and asserts that the capital is equal to "Kiev".
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The assertThat method from the AssertJ library is used for assertions.
 */
public class VerifyCountryCapitalByCode extends SoapBaseTest {

    @Description("Verify country capital by code")
    @Test(description = "Verify country capital by code")
    public void verifyCountryCapitalByCode() {
        Assertions.assertThat(country.getCountryCapitalByCode("UA"))
                .isEqualTo("Kiev")
                .as("Country capital and country code does not match");
    }
}
