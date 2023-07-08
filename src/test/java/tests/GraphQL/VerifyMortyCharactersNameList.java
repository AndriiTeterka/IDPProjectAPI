package tests.GraphQL;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.GraphQLBaseTest;

import java.util.List;

/**
 * This class contains a test case for verifying the names of Morty characters.
 * It extends the GraphQLBaseTest class.
 * The VerifyMortyCharactersNameList test case uses the characters object to retrieve a list of Morty character names
 * and asserts that each name contains the substring "Morty".
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 */
public class VerifyMortyCharactersNameList extends GraphQLBaseTest {

    @Description("Verify Morty characters names contain Morty")
    @Test(description = "Verify Morty characters names contain Morty")
    public void verifyMortyCharactersNameList() {
        List<String> names = characters.getMortyCharactersNames();
        for (String name : names) {
            Assertions.assertThat(name).contains("Morty");
        }
    }
}
