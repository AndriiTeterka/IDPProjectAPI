package tests.Users;

import io.qameta.allure.Description;
import models.UserPojo;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyCreatingNewUser extends BaseTest {

    @Description("Verify POST a new user")
    @Test(description = "Verify POST a new user")
    public void verifyCreatingNewUser() {
        UserPojo request = DataGenerator.createRandomUser();
        UserPojo response = user.createUser(request);

        assertThat(response)
                .isNotNull()
                .extracting(
                        UserPojo::getName,
                        UserPojo::getEmail,
                        UserPojo::getGender,
                        UserPojo::getStatus,
                        UserPojo::getBody)
                .containsExactly(
                        request.getName(),
                        request.getEmail(),
                        request.getGender(),
                        request.getStatus(),
                        request.getBody());
    }
}
