package tests.GraphQL;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.GraphQLBaseTest;

/**
 * This class contains a test case for verifying the count of all characters.
 * It extends the GraphQLBaseTest class.
 * The VerifyAllCharactersCount test case uses the characters object to retrieve the count of all characters
 * and asserts that the count is equal to 826.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 */
public class VerifyAllCharactersCount extends GraphQLBaseTest {

    @Description("Verify all characters count")
    @Test(description = "Verify all characters count")
    public void verifyAllCharactersCount() {
        Assertions.assertThat(characters.getAllCharactersCount()).isEqualTo(826);
    }
}
