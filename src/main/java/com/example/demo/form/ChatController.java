package com.example.demo.form;
import java.io.File;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
    @GetMapping("/random-image")
    @ResponseBody
    public String getRandomImage() {
        File directory = new File("static/image");
        File[] files = directory.listFiles();
        if (files != null && files.length > 0) {
            Random random = new Random();
            File randomFile = files[random.nextInt(files.length)];
            return "/image/" + randomFile.getName();
        }
        return "random";
    }
	
    
    @GetMapping("/random")
    public String show1() {
        return "random";
    }
    
    
}
	