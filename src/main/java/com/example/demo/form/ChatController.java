package com.example.demo.form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ChatController {

	@RequestMapping
	public String sample1(Model model) {
		//model.addAttribute("title","オフィスカジュアル");
		return "index";
	}
	
	@RequestMapping("/body")
	public String sample2(Model model){
		return "body";
	}
}
	