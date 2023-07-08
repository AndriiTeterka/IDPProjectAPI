package tests.Rest.Users;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

/**
 * This class contains a test case for verifying the deletion of an existing user.
 * It extends the RestBaseTest class.
 * The VerifyDeletingExistingUser test case uses the user object to retrieve the first user from the user list,
 * and then sends a request to delete that user using its ID.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 */
public class VerifyDeletingExistingUser extends RestBaseTest {

    @Description("Verify deleting existing user")
    @Test(description = "Verify deleting existing user")
    public void verifyDeletingExistingUser() {
        user.deleteUser(user.getUserList().stream().findFirst().get().getId());
    }
}
