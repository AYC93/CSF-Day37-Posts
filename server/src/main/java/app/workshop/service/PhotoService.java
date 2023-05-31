package app.workshop.service;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import app.workshop.model.PhotoPost;
import app.workshop.repository.PhotoRepository;

@Service
public class PhotoService {
    
    @Autowired 
    PhotoRepository photoRepo;

    public Optional<PhotoPost> getPhotoById(String photoId){
        return photoRepo.getImage(photoId);
    }

    public String postPhoto(String comment, MultipartFile image) throws IOException{
        String photoId = UUID.randomUUID().toString().substring(0, 8);
        photoRepo.addNewPost(photoId, comment, image.getBytes());
        return photoId;
    }
}
