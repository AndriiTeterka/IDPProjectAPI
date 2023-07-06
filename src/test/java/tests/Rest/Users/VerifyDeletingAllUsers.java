package tests.Rest.Users;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

public class VerifyDeletingAllUsers extends RestBaseTest {

    @Description("Verify deleting all users")
    @Test(description = "Verify deleting all users")
    public void verifyDeletingAllUsers() {
        user.deleteAllUsers();
    }
}
