package tests;

import models.UserPojo;
import org.testng.annotations.Test;
import utils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RestTest extends BaseTest {

    @Test
    public void getUsers() {
        assertThat(user.getUserList()).extracting(UserPojo::getEmail).contains("chiranjeev_marar@armstrong.test");
    }

    @Test
    public void verifyCreatedUser() {
        UserPojo request = DataGenerator.createRandomUser();
        UserPojo response = user.createUser(request);

        assertThat(response)
                .isNotNull()
                .extracting(UserPojo::getGender)
                .isEqualTo(request.getGender());
    }

    @Test
    public void getUsers2() {
        UserPojo s = user.getUserById(2993079);
        int i =0;
    }
}
