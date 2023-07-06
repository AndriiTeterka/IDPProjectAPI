package tests.Soap.Countries;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.SoapBaseTest;

public class VerifyCountryCapitalByCode extends SoapBaseTest {

    @Description("Verify country capital by code")
    @Test(description = "Verify country capital by code")
    public void verifyCountryCapitalByCode() {
        Assertions.assertThat(country.getCountryCapitalByCode("UA"))
                .isEqualTo("Kiev")
                .as("Country capital and country code does not match");
    }
}
