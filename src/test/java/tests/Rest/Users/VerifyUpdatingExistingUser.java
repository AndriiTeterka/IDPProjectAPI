package tests.Rest.Users;

import io.qameta.allure.Description;
import models.UserPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;
import utils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class contains a test case for verifying the updating of an existing user using a PUT request.
 * It extends the RestBaseTest class.
 * The VerifyUpdatingExistingUser test case generates a random user using the DataGenerator class,
 * retrieves the ID of an existing user from the user list,
 * and then sends a PUT request to update the user using its ID.
 * The test asserts that the response is not null and that the response properties match the updated request properties.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The DataGenerator class is used to generate a random user.
 * The assertThat method from the AssertJ library is used for assertions.
 */
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
