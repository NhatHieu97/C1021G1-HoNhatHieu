package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@Controller
public class TranslateDictionary {
    private Dictionary dictionary = new Dictionary();
    Map<String,String> dictionarys = dictionary.mapDictionary();
    @GetMapping("/")
    public String home() {
        return "/home";
    }
    @GetMapping("/translate")
    public String translate(@RequestParam String english, Model model){
        for (Map.Entry<String,String> entry: dictionarys.entrySet()){
            if (entry.getKey().toLowerCase().equals(english.toLowerCase())){
                model.addAttribute("vietnamese",entry.getValue());
            }else
                model.addAttribute("message","không tìm thấy!!!");
        }
        return "/home";
    }
}
