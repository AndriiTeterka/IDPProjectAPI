package tests.Rest.Users;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyGettingUserById extends RestBaseTest {

    @Description("Verify GET user by id")
    @Test(description = "Verify GET user by id")
    public void verifyGettingUserById() {
        int userId = user.getUserList().stream().findFirst().get().getId();
        assertThat(user.getUserById(userId).getId()).isEqualTo(userId);
    }
}
