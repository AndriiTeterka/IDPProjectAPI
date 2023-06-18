package models;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CommentPojo extends BasePojo {

    private int postId;
}
