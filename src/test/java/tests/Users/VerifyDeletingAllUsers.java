package tests.Users;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;

public class VerifyDeletingAllUsers extends BaseTest {

    @Description("Verify deleting all users")
    @Test(description = "Verify deleting all users")
    public void verifyDeletingAllUsers() {
        user.deleteAllUsers();
    }
}
