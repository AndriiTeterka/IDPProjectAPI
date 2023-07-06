package tests.Soap.Countries;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.SoapBaseTest;

public class VerifyCountryCurrencyNameByCode extends SoapBaseTest {

    @Description("Verify country currency name by country code")
    @Test(description = "Verify country currency name by country code")
    public void verifyCountryCurrencyNameByCode() {
        Assertions.assertThat(country.getCountryCurrencyNameByCode("UA"))
                .isEqualTo("Hryvnia")
                .as("Country currency and country code does not match");
    }
}
