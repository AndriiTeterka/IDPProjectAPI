package tests.Rest.Users;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

public class VerifyDeletingExistingUser extends RestBaseTest {

    @Description("Verify deleting existing user")
    @Test(description = "Verify deleting existing user")
    public void verifyDeletingExistingUser() {
        user.deleteUser(user.getUserList().stream().findFirst().get().getId());
    }
}
