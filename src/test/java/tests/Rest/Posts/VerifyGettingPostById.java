package tests.Rest.Posts;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class contains a test case for verifying the retrieval of a post by its ID using a GET request.
 * It extends the RestBaseTest class.
 * The VerifyGettingPostById test case uses the post object to retrieve the first post from the post list,
 * gets its ID, and then sends a GET request to retrieve the post by its ID.
 * The test asserts that the ID of the retrieved post matches the original post ID.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The assertThat method from the AssertJ library is used for assertions.
 */
public class VerifyGettingPostById extends RestBaseTest {

    @Description("Verify GET post by id")
    @Test(description = "Verify GET post by id")
    public void verifyGettingPostById() {
        int postId = post.getPostList().stream().findFirst().get().getId();
        assertThat(post.getPostById(postId).getId()).isEqualTo(postId);
    }
}
