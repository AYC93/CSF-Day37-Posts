package day37.wkshp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static day37.wkshp.model.Queries.*;

@Repository
public class PhotoRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addNewPost(String photoId, String contentType, byte[] picture){
        jdbcTemplate.update(SQL_SAVE_PHOTO, photoId, contentType, picture);
    }
}
