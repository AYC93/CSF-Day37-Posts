package app.workshop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import app.workshop.model.PhotoPost;
import app.workshop.service.PhotoService;

@Controller
@RequestMapping
public class PhotoController {
    
    @Autowired
    PhotoService photoSvc;

	@GetMapping(path="/post/image/{image}")
	@ResponseBody
	public ResponseEntity<byte[]> getImage(@PathVariable String image) {
		Optional<PhotoPost> opt = photoSvc.getPhotoById(image);
		if (opt.isEmpty())
			return ResponseEntity.notFound().build();

		PhotoPost photo = opt.get();

		return ResponseEntity
					.status(200)
					.header("Content-Type", photo.getContentType())
					.body(photo.getPicture());
	}

    @PostMapping(path="/posts", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ModelAndView postPosts(@RequestPart String comments, 
								 @RequestPart MultipartFile image) {

		ModelAndView mv = new ModelAndView();
		String postId = null;

		try {
			postId = photoSvc.postPhoto(comments, image);
		} catch (Exception ex) {
			ex.printStackTrace();
			mv.setStatus(HttpStatusCode.valueOf(500));
			mv.addObject("error", ex.getMessage());
			mv.setViewName("error");
			return mv;
		}

		mv.setViewName("posts");
		mv.addObject("comments", comments);
		mv.addObject("image", "/post/image/%s".formatted(postId));

		return mv;
	}

}
