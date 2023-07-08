package tests.Rest.Posts;

import io.qameta.allure.Description;
import models.PostPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;
import utils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class contains a test case for verifying the creation of a new post using a POST request.
 * It extends the RestBaseTest class.
 * The VerifyCreatingNewPost test case generates a random post using the DataGenerator class,
 * associates it with a user by retrieving the first user from the user list,
 * and then sends a POST request to create the post.
 * The test asserts that the response is not null and that the response properties match the request properties.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The DataGenerator class is used to generate a random post based on a user ID.
 * The assertThat method from the AssertJ library is used for assertions.
 */
public class VerifyCreatingNewPost extends RestBaseTest {

    @Description("Verify POST a new post")
    @Test(description = "Verify POST a new post")
    public void verifyCreatingNewPost() {
        PostPojo request = DataGenerator.createRandomPostByUserId(user.getUserList().stream().findFirst().get().getId());
        PostPojo response = post.createPost(request);

        assertThat(response)
                .isNotNull()
                .extracting(
                        PostPojo::getUserId,
                        PostPojo::getTitle,
                        PostPojo::getBody,
                        PostPojo::getName)
                .containsExactly(
                        request.getUserId(),
                        request.getTitle(),
                        request.getBody(),
                        request.getName());
    }
}
