package utils;

import com.github.javafaker.Faker;
import models.CommentPojo;
import models.PostPojo;
import models.UserPojo;

/**
 * This class provides utility methods for generating random data for different models.
 * The createRandomUser method generates a random UserPojo object with random values for id, name, email, gender, and status.
 * The createRandomPostByUserId method generates a random PostPojo object with a specified userId and random values for id, title, and body.
 * The createRandomCommentByPostId method generates a random CommentPojo object with a specified postId and random values for id, name, email, and body.
 * These methods utilize the JavaFaker library to generate realistic and random data.
 */
public class DataGenerator {

    public static UserPojo createRandomUser() {
        Faker faker = new Faker();
        return UserPojo.builder()
                .id(faker.number().numberBetween(1, 999))
                .name(faker.name().name())
                .email(faker.internet().emailAddress())
                .gender(faker.options().option("male", "female"))
                .status(faker.options().option("active", "inactive"))
                .build();
    }

    public static PostPojo createRandomPostByUserId(int id) {
        Faker faker = new Faker();
        return PostPojo.builder()
                .id(faker.number().numberBetween(1, 999))
                .userId(id)
                .title(faker.lorem().word())
                .body(faker.lorem().paragraph())
                .build();
    }

    public static CommentPojo createRandomCommentByPostId(int id) {
        Faker faker = new Faker();
        return CommentPojo.builder()
                .id(faker.number().numberBetween(1, 999))
                .postId(id)
                .name(faker.name().name())
                .email(faker.internet().emailAddress())
                .body(faker.lorem().paragraph())
                .build();
    }
}
