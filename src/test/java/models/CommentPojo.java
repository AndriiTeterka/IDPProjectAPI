package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * This class represents a CommentPojo, which is a model class for comments.
 * It extends the BasePojo class.
 * The CommentPojo contains information about a comment, such as its postId.
 * Note: This class uses Lombok annotations for generating getter, setter, and builder methods.
 * The @Data annotation generates the getter and setter methods.
 * The @SuperBuilder annotation enables the builder pattern for this class.
 * The @NoArgsConstructor annotation generates a no-argument constructor.
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class CommentPojo extends BasePojo {

    @JsonProperty("post_id")
    private int postId;
}
