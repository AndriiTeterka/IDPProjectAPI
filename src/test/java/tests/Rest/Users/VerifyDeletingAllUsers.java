package tests.Rest.Users;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

/**
 * This class contains a test case for verifying the deletion of all users.
 * It extends the RestBaseTest class.
 * The VerifyDeletingAllUsers test case uses the user object to send a request to delete all users.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 */
public class VerifyDeletingAllUsers extends RestBaseTest {

    @Description("Verify deleting all users")
    @Test(description = "Verify deleting all users")
    public void verifyDeletingAllUsers() {
        user.deleteAllUsers();
    }
}
