package ilanaraba.com.controllers;

import ilanaraba.com.entitites.Ilan;
import ilanaraba.com.entitites.Image;
import ilanaraba.com.services.IlanService;
import ilanaraba.com.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("*")
public class AdminController {

    @Autowired
    private IlanService ilanService;
    @Autowired
    private ImageService imageService;

    @GetMapping("/admin")
    public String ilanlariListele(Model model) {
        List<Ilan> ilanList = ilanService.getTumIlanlar();
        model.addAttribute("ilanList", ilanList);
        model.addAttribute("newIlan", new Ilan());
        return "admin";
    }
    @GetMapping("/admin/ilanekle")
    public String ilanekle(Model model) {
        model.addAttribute("newIlan", new Ilan());
        return "ilanekle";
    }
    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("pageTitle", "Giriş Yap");
        return "login";
    }

    @PostMapping("/admin/ilanekle")
    public String ilaniKaydet(@ModelAttribute("newIlan") Ilan ilan,@RequestParam("resimUrls") List<String> resimUrls) {
       ilanService.ilaniKaydet(ilan);


        for (String imageUrl : resimUrls) {
            Image image = new Image();
            image.setUrl(imageUrl);
            image.setIlan(ilan);
           imageService.save(image);
        }

        return "redirect:/admin";
    }

    @GetMapping("/admin/sil/{id}")
    public String ilaniSil(@PathVariable Long id) {
        ilanService.ilaniSil(id);
        return "redirect:/admin";
    }
}