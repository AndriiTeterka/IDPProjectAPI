package tests.GraphQL;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.GraphQLBaseTest;

/**
 * This class contains a test case for verifying the count of Rick characters.
 * It extends the GraphQLBaseTest class.
 * The VerifyRickCharactersCount test case uses the characters object to retrieve the count of Rick characters
 * and asserts that the count is equal to 107.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 */
public class VerifyRickCharactersCount extends GraphQLBaseTest {

    @Description("Verify Rick characters count")
    @Test(description = "Verify Rick characters count")
    public void verifyRickCharactersCount() {
        Assertions.assertThat(characters.getRickCharactersCount()).isEqualTo(107);
    }
}
