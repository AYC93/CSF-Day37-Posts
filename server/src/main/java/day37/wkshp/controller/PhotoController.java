package day37.wkshp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import day37.wkshp.service.PhotoService;

@Controller
@RequestMapping
public class PhotoController {
    
    @Autowired
    PhotoService photoSvc;

    // incomplete
    @PostMapping(path="/posts", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ModelAndView postPosts(@RequestPart String comments, @RequestPart String content
			, @RequestPart MultipartFile image) {

		ModelAndView mv = new ModelAndView();
		String postId = null;

		try {
			postId = photoSvc.postPhoto(comments, content, image);
		} catch (Exception ex) {
			ex.printStackTrace();
			mv.setStatus(HttpStatusCode.valueOf(500));
			mv.addObject("error", ex.getMessage());
			mv.setViewName("error");
			return mv;
		}

		mv.setViewName("post");
		mv.addObject("comments", comments);
		mv.addObject("content", content);
		mv.addObject("image", "/post/image/%s".formatted(postId));

		return mv;
	}
}
