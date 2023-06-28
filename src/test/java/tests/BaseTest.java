package tests;

import org.testng.annotations.BeforeTest;
import utils.services.CommentService;
import utils.services.PostService;
import utils.services.UserService;

public class BaseTest {

    public UserService user;
    public PostService post;
    public CommentService comment;

    @BeforeTest
    public void setUpServices() {
        user = new UserService();
        post = new PostService();
        comment = new CommentService();
    }
}
