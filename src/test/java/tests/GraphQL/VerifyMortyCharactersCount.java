package tests.GraphQL;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.GraphQLBaseTest;

/**
 * This class contains a test case for verifying the count of Morty characters.
 * It extends the GraphQLBaseTest class.
 * The VerifyMortyCharactersCount test case uses the characters object to retrieve the count of Morty characters
 * and asserts that the count is equal to 68.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 */
public class VerifyMortyCharactersCount extends GraphQLBaseTest {

    @Description("Verify Morty characters count")
    @Test(description = "Verify Morty characters count")
    public void verifyMortyCharactersCount() {
        Assertions.assertThat(characters.getMortyCharactersCount()).isEqualTo(68);
    }
}
