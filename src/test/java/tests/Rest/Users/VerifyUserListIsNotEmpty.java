package tests.Rest.Users;

import io.qameta.allure.Description;
import models.UserPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class contains a test case for verifying that the user list is not empty.
 * It extends the RestBaseTest class.
 * The VerifyUserListIsNotEmpty test case uses the user object to retrieve the user list,
 * and asserts that the list is not null and not empty by extracting the ids of the users.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The assertThat method from the AssertJ library is used for assertions.
 */
public class VerifyUserListIsNotEmpty extends RestBaseTest {

    @Description("Verify user list is not empty")
    @Test(description = "Verify user list is not empty")
    public void verifyUserListIsNotEmpty() {
        assertThat(user.getUserList()).extracting(UserPojo::getId).isNotNull().isNotEmpty();
    }
}
