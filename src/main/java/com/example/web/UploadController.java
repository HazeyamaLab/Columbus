package com.example.web;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Picture;
import com.example.domain.UploadForm;
import com.example.service.LoginUserDetails;
import com.example.service.PictureService;

@Controller
@RequestMapping("upload")
public class UploadController {
	
	@Autowired 
	PictureService pictureservice;
	
	
	@ModelAttribute
	UploadForm setUpForm() {
		return new UploadForm();
	}
	
	@GetMapping
	String getUpload(Model model) {
		return "uploadForm";
	}
	
	@PostMapping
	String postUplpad(@Validated UploadForm form, BindingResult result,Model model,@AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		if(result.hasErrors()) {
			return getUpload(model);
		}
		String pathname = "/Users/Columbus/"+loginUserDetails.getUsername().toString()+"/";
		
		//Pathがすでに存在しているかを確認、なければcreate
		Path path = Paths.get(pathname);
		 if (!Files.exists(path)) {
		   try {
		     Files.createDirectories(path);
		   } catch (NoSuchFileException ex) {
		     System.err.println(ex);
		   } catch (IOException ex) {
		     System.err.println(ex);
		   }
		 }
		String filename = form.getFile().getOriginalFilename();
		Path uploadfile = Paths.get(pathname + filename);
		int prefix = 0;
		
		while(Files.exists(uploadfile)) {
			prefix ++;
			uploadfile = Paths.get(pathname + filename + String.valueOf(prefix));
		}
		
		try (OutputStream os = Files.newOutputStream(uploadfile, StandardOpenOption.CREATE)) {
		    byte[] bytes = form.getFile().getBytes();
		    os.write(bytes);
		  } catch (IOException ex) {
		    System.err.println(ex);
		  }
		return	"redirect:upload";
	}
	

}
