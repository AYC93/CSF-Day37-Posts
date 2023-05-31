package app.workshop.model;

public class Queries {

    public static final String SQL_SAVE_PHOTO= """
        insert into image(post_id, comments, picture) values (?, ?, ?)
        """;
        
    public static final String SQL_GET_IMAGE_BY_ID= """
        select * from image where post_id = ?
            """;
}
