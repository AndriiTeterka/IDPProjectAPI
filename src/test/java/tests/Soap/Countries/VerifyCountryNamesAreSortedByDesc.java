package tests.Soap.Countries;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.SoapBaseTest;

import java.util.stream.Collectors;

public class VerifyCountryNamesAreSortedByDesc extends SoapBaseTest {

    @Description("Verify country names are sorted by descending")
    @Test(description = "Verify country names are sorted by descending")
    public void verifyCountryNamesAreSortedByDesc() {
        Assertions.assertThat(country.getCountryNameList())
                .isEqualTo(country.getCountryNameList().stream().sorted().collect(Collectors.toList()));
    }
}
