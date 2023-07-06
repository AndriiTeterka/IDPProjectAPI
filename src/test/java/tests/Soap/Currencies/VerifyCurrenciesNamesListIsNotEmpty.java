package tests.Soap.Currencies;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.SoapBaseTest;

public class VerifyCurrenciesNamesListIsNotEmpty extends SoapBaseTest {

    @Description("Verify currency name list is not empty")
    @Test(description = "Verify currency name list is not empty")
    public void verifyCurrenciesNamesListIsNotEmpty() {
        Assertions.assertThat(currency.getCurrencyNameList()).isNotEmpty();
    }
}
