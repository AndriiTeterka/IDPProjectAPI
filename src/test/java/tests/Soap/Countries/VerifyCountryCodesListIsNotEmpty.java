package tests.Soap.Countries;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.SoapBaseTest;

/**
 * This class contains a test case for verifying that the list of country codes is not empty.
 * It extends the SoapBaseTest class.
 * The VerifyCountryCodesListIsNotEmpty test case uses the country object to retrieve the list of country codes,
 * and asserts that the list is not empty.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The assertThat method from the AssertJ library is used for assertions.
 */
public class VerifyCountryCodesListIsNotEmpty extends SoapBaseTest {

    @Description("Verify country codes is not empty")
    @Test(description = "Verify country codes is not empty")
    public void verifyCountryCodesListIsNotEmpty() {
        Assertions.assertThat(country.getCountryCodeList()).isNotEmpty();
    }
}
