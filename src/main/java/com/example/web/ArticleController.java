package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
	@GetMapping(path = "postArticle")
	String postArticle() {
		return "postArticle";
	}
}
