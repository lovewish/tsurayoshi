package com.example.demo.form;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	
    @RequestMapping("/random-image")
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
	
    
    @RequestMapping("/random")
    public String show1() {
        return "random";
    }
    
    
    
    @RequestMapping("/image")
    public String show() {
        return "image";
    }
    
    /** 画像アップロード＆表示 */
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file, Model model) {

        try {
            if (!file.isEmpty()) {
                // 保存先ディレクトリを作成
                File directory = new File("static/image");
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // ファイル名
                String filename = file.getOriginalFilename();
                // ファイルパス
                String filePath = directory.getAbsolutePath() + File.separator + filename;
                // ファイルを保存
                Files.write(Paths.get(filePath), file.getBytes());

                // アップロードした画像のURLを画面に渡す
                String imageUrl = "/image/" + filename;
                model.addAttribute("imageUrl", imageUrl);
            }
        } catch (IOException e) {
            // エラー時
            e.printStackTrace();
        }
        
        // image.htmlを描画
        return "image";
        
    }
    
}
	