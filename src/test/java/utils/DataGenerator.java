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

    public static PostPojo createRandomPost() {
        Faker faker = new Faker();
        return PostPojo.builder()
                .id(faker.number().numberBetween(1, 999))
                .userId(faker.number().numberBetween(1, 999))
                .title(faker.lorem().word())
                .body(faker.lorem().paragraph())
                .build();
    }

    public static CommentPojo createRandomComment() {
        Faker faker = new Faker();
        return CommentPojo.builder()
                .id(faker.number().numberBetween(1, 999))
                .postId(faker.number().numberBetween(1, 999))
                .name(faker.name().name())
                .email(faker.internet().emailAddress())
                .body(faker.lorem().paragraph())
                .build();
    }
}
