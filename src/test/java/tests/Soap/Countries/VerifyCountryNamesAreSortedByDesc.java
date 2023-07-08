package tests.Soap.Countries;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.SoapBaseTest;

import java.util.stream.Collectors;

/**
 * This class contains a test case for verifying that the country names are sorted in descending order.
 * It extends the SoapBaseTest class.
 * The VerifyCountryNamesAreSortedByDesc test case uses the country object to retrieve the list of country names,
 * and asserts that the list is equal to the sorted list of country names in descending order.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The assertThat method from the AssertJ library is used for assertions.
 * The Collectors.toList() method is used to collect the sorted country names into a List.
 */
public class VerifyCountryNamesAreSortedByDesc extends SoapBaseTest {

    @Description("Verify country names are sorted by descending")
    @Test(description = "Verify country names are sorted by descending")
    public void verifyCountryNamesAreSortedByDesc() {
        Assertions.assertThat(country.getCountryNameList())
                .isEqualTo(country.getCountryNameList().stream().sorted().collect(Collectors.toList()));
    }
}
