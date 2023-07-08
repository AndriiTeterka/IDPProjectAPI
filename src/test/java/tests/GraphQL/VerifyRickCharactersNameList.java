package tests.GraphQL;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.GraphQLBaseTest;

import java.util.List;

/**
 * This class contains a test case for verifying the names of Rick characters.
 * It extends the GraphQLBaseTest class.
 * The VerifyRickCharactersNameList test case uses the characters object to retrieve a list of Rick character names
 * and asserts that each name contains the substring "Rick".
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 */
public class VerifyRickCharactersNameList extends GraphQLBaseTest {

    @Description("Verify Rick characters names contain Rick")
    @Test(description = "Verify Rick characters names contain Rick")
    public void verifyRickCharactersNameList() {
        List<String> names = characters.getRickCharactersNames();
        for (String name : names) {
            Assertions.assertThat(name).contains("Rick");
        }
    }
}
