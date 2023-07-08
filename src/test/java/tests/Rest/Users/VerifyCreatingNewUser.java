package tests.Rest.Users;

import io.qameta.allure.Description;
import models.UserPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;
import utils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class contains a test case for verifying the creation of a new user using a POST request.
 * It extends the RestBaseTest class.
 * The VerifyCreatingNewUser test case generates a random user using the DataGenerator class,
 * and then sends a POST request to create the user.
 * The test asserts that the response is not null and that the response properties match the request properties.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The DataGenerator class is used to generate a random user.
 * The assertThat method from the AssertJ library is used for assertions.
 */
public class VerifyCreatingNewUser extends RestBaseTest {

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
