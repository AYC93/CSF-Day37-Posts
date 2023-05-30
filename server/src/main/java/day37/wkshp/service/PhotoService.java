package day37.wkshp.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import day37.wkshp.repository.PhotoRepository;

@Service
public class PhotoService {
    
    @Autowired 
    PhotoRepository photoRepo;

    public String postPhoto(String photoId, String comments, MultipartFile image) throws IOException{
        photoId = UUID.randomUUID().toString().substring(0, 8);
        photoRepo.addNewPost(photoId, comments, image.getBytes());
        return photoId;
    }
}
