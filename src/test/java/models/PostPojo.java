package models;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PostPojo extends BasePojo {

    private int userId;
    private String title;
}
