package utils;

import com.github.javafaker.Faker;
import models.CommentPojo;
import models.PostPojo;
import models.UserPojo;

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
