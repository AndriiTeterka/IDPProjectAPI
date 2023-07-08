package tests.Rest.Comments;

import io.qameta.allure.Description;
import models.CommentPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class contains a test case for verifying that the comment list is not empty.
 * It extends the RestBaseTest class.
 * The VerifyCommentListIsNotEmpty test case uses the comment object to retrieve the comment list,
 * and asserts that the list is not null and not empty by extracting the ids of the comments.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 */
public class VerifyCommentListIsNotEmpty extends RestBaseTest {

    @Description("Verify comment list is not empty")
    @Test(description = "Verify comment list is not empty")
    public void verifyCommentListIsNotEmpty() {
        assertThat(comment.getCommentList()).extracting(CommentPojo::getId).isNotNull().isNotEmpty();
    }
}
