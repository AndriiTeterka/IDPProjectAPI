package tests.Soap.Countries;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.SoapBaseTest;

public class VerifyCountryCodesListIsNotEmpty extends SoapBaseTest {

    @Description("Verify country codes is not empty")
    @Test(description = "Verify country codes is not empty")
    public void verifyCountryCodesListIsNotEmpty() {
        Assertions.assertThat(country.getCountryCodeList()).isNotEmpty();
    }
}
