package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@org.springframework.stereotype.Controller
public class UngDungChuyenDoiTienTe {
    private final UngDung ungDung = new UngDung();

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @GetMapping("/chuyendoi")
    public String chuyenDoi(@RequestParam String USD, Model model) {

        if (USD.equals("")) {
            model.addAttribute("result", "Vui long nhập lại !");
        } else {
            double resultFinal = ungDung.chuyenDoi(Double.parseDouble(USD));

            model.addAttribute("result", resultFinal);
        }
        return "/home";
    }
}
