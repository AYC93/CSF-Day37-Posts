package app.workshop.model;

public class PhotoPost {
    
    String photoId;
    String comments;
    String contentType;
    byte[] picture;

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public PhotoPost(String photoId, String comments, byte[] picture) {
        this.photoId = photoId;
        this.comments = comments;
        this.picture = picture;
    }

    public PhotoPost() {
    }

    

}
