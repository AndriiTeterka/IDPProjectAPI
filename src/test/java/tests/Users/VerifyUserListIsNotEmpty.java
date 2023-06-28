package tests.Users;

import io.qameta.allure.Description;
import models.UserPojo;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyUserListIsNotEmpty extends BaseTest {

    @Description("Verify user list is not empty")
    @Test(description = "Verify user list is not empty")
    public void verifyUserListIsNotEmpty() {
        assertThat(user.getUserList()).extracting(UserPojo::getId).isNotNull().isNotEmpty();
    }
}
