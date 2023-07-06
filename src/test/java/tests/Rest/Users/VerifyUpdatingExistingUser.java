package tests.Rest.Users;

import io.qameta.allure.Description;
import models.UserPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;
import utils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyUpdatingExistingUser extends RestBaseTest {

    @Description("Verify updating existing user")
    @Test(description = "Verify updating existing user")
    public void verifyUpdatingExistingUser() {
        UserPojo request = DataGenerator.createRandomUser();
        UserPojo response = user.updateUser(request, user.getUserList().stream().findFirst().get().getId());

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
