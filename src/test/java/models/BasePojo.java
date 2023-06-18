package models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class BasePojo {

    private int id;
    private String name;
    private String email;
    private String body;
}
