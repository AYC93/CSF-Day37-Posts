package day37.wkshp.model;

public class Queries {

    public static final String SQL_SAVE_PHOTO= """
            insert into image(comments, media_type, picture) values (?, ?, ?)
            """;
    
}
