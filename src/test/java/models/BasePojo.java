package models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * This class represents a BasePojo, which is a base model class for other Pojo classes.
 * The BasePojo contains common properties such as id, name, email, and body.
 * Note: This class uses Lombok annotations for generating getter, setter, and builder methods.
 * The @Data annotation generates the getter and setter methods.
 * The @NoArgsConstructor annotation generates a no-argument constructor.
 * The @SuperBuilder annotation enables the builder pattern for this class.
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class BasePojo {

    private int id;
    private String name;
    private String email;
    private String body;
}
