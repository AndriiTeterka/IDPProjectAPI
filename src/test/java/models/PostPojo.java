package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * This class represents a PostPojo, which is a model class for posts.
 * It extends the BasePojo class.
 * The PostPojo contains information about a post, such as its userId and title.
 * Note: This class uses Lombok annotations for generating getter, setter, and builder methods.
 * The @Data annotation generates the getter and setter methods.
 * The @SuperBuilder annotation enables the builder pattern for this class.
 * The @NoArgsConstructor annotation generates a no-argument constructor.
 * The "userId" property is annotated with @JsonProperty to specify the JSON property name as "user_id".
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class PostPojo extends BasePojo {

    @JsonProperty("user_id")
    private int userId;
    private String title;
}
