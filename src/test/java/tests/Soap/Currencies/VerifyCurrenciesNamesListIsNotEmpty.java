package tests.Soap.Currencies;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.SoapBaseTest;

/**
 * This class contains a test case for verifying that the list of currency names is not empty.
 * It extends the SoapBaseTest class.
 * The VerifyCurrenciesNamesListIsNotEmpty test case uses the currency object to retrieve the list of currency names,
 * and asserts that the list is not empty.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The assertThat method from the AssertJ library is used for assertions.
 */
public class VerifyCurrenciesNamesListIsNotEmpty extends SoapBaseTest {

    @Description("Verify currency name list is not empty")
    @Test(description = "Verify currency name list is not empty")
    public void verifyCurrenciesNamesListIsNotEmpty() {
        Assertions.assertThat(currency.getCurrencyNameList()).isNotEmpty();
    }
}
