package models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * This class represents a UserPojo, which is a model class for users.
 * It extends the BasePojo class.
 * The UserPojo contains information about a user, such as their gender and status.
 * Note: This class uses Lombok annotations for generating getter, setter, and builder methods.
 * The @Data annotation generates the getter and setter methods.
 * The @SuperBuilder annotation enables the builder pattern for this class.
 * The @NoArgsConstructor annotation generates a no-argument constructor.
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class UserPojo extends BasePojo {

    private String gender;
    private String status;
}
