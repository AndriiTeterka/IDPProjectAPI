package tests.Users;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;

public class VerifyDeletingExistingUser extends BaseTest {

    @Description("Verify deleting existing user")
    @Test(description = "Verify deleting existing user")
    public void verifyDeletingExistingUser() {
        user.deleteUser(user.getUserList().stream().findFirst().get().getId());
    }
}
