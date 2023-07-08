package tests.Rest.Posts;

import io.qameta.allure.Description;
import models.PostPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;
import utils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class contains a test case for verifying the updating of an existing post using a PUT request.
 * It extends the RestBaseTest class.
 * The VerifyUpdatingExistingPost test case generates a random post using the DataGenerator class,
 * associates it with a user by retrieving the first user from the user list,
 * retrieves the ID of an existing post from the post list,
 * and then sends a PUT request to update the post using its ID.
 * The test asserts that the response is not null and that the response properties match the updated request properties.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The DataGenerator class is used to generate a random post based on a user ID.
 * The assertThat method from the AssertJ library is used for assertions.
 */
public class VerifyUpdatingExistingPost extends RestBaseTest {

    @Description("Verify updating existing post")
    @Test(description = "Verify updating existing post")
    public void verifyUpdatingExistingPost() {
        PostPojo request = DataGenerator.createRandomPostByUserId(user.getUserList().stream().findFirst().get().getId());
        PostPojo response = post.updatePost(request, post.getPostList().stream().findFirst().get().getId());

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
