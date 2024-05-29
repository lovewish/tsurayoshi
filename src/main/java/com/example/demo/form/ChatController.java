package com.example.demo.form;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ChatController {

	@GetMapping("/")
    public String sample1(Model model) {
        return "index";
    }
    
    @GetMapping("/body")
    public String sample2 (Model model){
        return "body";
    }
    
    @GetMapping("/image")
    public String show() {
        return "image";
    }
    
    /** 画像アップロード＆表示 */
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file, Model model) {

        try {
            if (!file.isEmpty()) {
                // 保存先ディレクトリを作成
                File directory = new File("src/main/resources/static/image");
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
    
    @GetMapping("/random")
    public String home() {
        return "random";
    }

    private final String IMAGE_DIRECTORY = "src/main/resources/static/image";

    @GetMapping("/random-image")
    @ResponseBody
    public String getRandomImage() {
        File directory = new File(IMAGE_DIRECTORY);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".jpg") || name.endsWith(".png"));
        if (files != null && files.length > 0) {
            Random random = new Random();
            File randomFile = files[random.nextInt(files.length)];
            return randomFile.getName();
        }
        return "";
    }
    
    


    @GetMapping("/imageall")
    public String showAllImages() {
        return "imageall";
    }

    @GetMapping("/all-images")
    @ResponseBody
    public List<String> getAllImages() {
        List<String> imageNames = new ArrayList<>();
        File directory = new File(IMAGE_DIRECTORY);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".jpg") || name.endsWith(".png"));
        if (files != null) {
            for (File file : files) {
                imageNames.add(file.getName());
            }
        }
        return imageNames;
    }
    
    
    
    //吉田の追加
    @GetMapping("/male")
    public String showMalePage() {
        return "male"; // male.htmlに対応するテンプレート名を返す
    }

    @GetMapping("/female")
    public String showFemalePage() {
        return "female"; // female.htmlに対応するテンプレート名を返す
    }

    @GetMapping("/all")
    public String showAllPage() {
        return "all"; // all.htmlに対応するテンプレート名を返す
    }
    
}
	