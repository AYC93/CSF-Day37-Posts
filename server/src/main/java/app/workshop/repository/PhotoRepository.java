package app.workshop.repository;

import static app.workshop.model.Queries.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import app.workshop.model.PhotoPost;

@Repository
public class PhotoRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<PhotoPost> getImage(String photoId) {
        return jdbcTemplate.query(SQL_GET_IMAGE_BY_ID,
                rs -> {
                    if (!rs.next())
                        return Optional.empty();
                    return Optional.of(new PhotoPost(photoId, rs.getString("comments"), 
                                        rs.getBytes("picture")));
                },
                photoId);
    }

    public void addNewPost(String photoId, String comments, byte[] picture) {
        jdbcTemplate.update(SQL_SAVE_PHOTO, photoId, comments, picture);
    }
}
