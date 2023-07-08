package tests.Rest.Users;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class contains a test case for verifying the retrieval of a user by its ID using a GET request.
 * It extends the RestBaseTest class.
 * The VerifyGettingUserById test case uses the user object to retrieve the first user from the user list,
 * gets its ID, and then sends a GET request to retrieve the user by its ID.
 * The test asserts that the ID of the retrieved user matches the original user ID.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The assertThat method from the AssertJ library is used for assertions.
 */
public class VerifyGettingUserById extends RestBaseTest {

    @Description("Verify GET user by id")
    @Test(description = "Verify GET user by id")
    public void verifyGettingUserById() {
        int userId = user.getUserList().stream().findFirst().get().getId();
        assertThat(user.getUserById(userId).getId()).isEqualTo(userId);
    }
}
