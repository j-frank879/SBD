package com.example.controllers;

import com.example.entity.Artykul;
import com.example.repository.ArtykulRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ArtykulController {

    @Autowired
    private ArtykulRepository artykulRepository;

    @GetMapping("/")
    public String mainRedirect() {return "redirect:/articles";}

    @GetMapping("/articles")
    public String getAll(HttpSession session, Model model, @Param("keyword") String keyword) {
        try {
            List<Artykul> articles = new ArrayList<Artykul>();

            if (keyword == null) {
                artykulRepository.findAll().forEach(articles::add);
            } else {
                artykulRepository.findBynazwaContainingIgnoreCase(keyword).forEach(articles::add);
                model.addAttribute("keyword", keyword);
            }

            model.addAttribute("articles", articles);
            //model.addAttribute("session", session);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "article_list";
    }

    @GetMapping("/articles/{id}")
    public String editArticle(@PathVariable("id") Long id, HttpSession session, Model model) {
        try {
            Optional<Artykul> article;

            article = artykulRepository.findById(id);

            model.addAttribute("artykul", article);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        //model.addAttribute("session", session);

        return "article_editor";
    }

    @GetMapping("/articleEditor")
    public String main(HttpSession session, Model model) {
        model.addAttribute("artykul", new Artykul());
        //model.addAttribute("session", session);
        return "article_editor";
    }

    @PostMapping("/articleEditor")
    public String save(HttpSession session, Artykul artykul, Model model) {
        artykul.setnazwaAutora(session.getAttribute("username").toString());
        artykul.setdataPrzeslania(new Date());
        model.addAttribute("artykul", artykul);
        //model.addAttribute("session", session);
        artykulRepository.save(artykul);
        System.out.println(artykul.getId() + " " + artykul.getNazwa() + " " + artykul.getContent());
        System.out.println("save called");
        return "redirect:/articles";
    }

    @GetMapping("/articles/delete/{id}")
    public String deleteTutorial(@PathVariable("id") Long id, HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        try {
            artykulRepository.deleteById(id);

            redirectAttributes.addFlashAttribute("message", "The Article with id=" + id + " has been deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        //model.addAttribute("session", session);

        return "redirect:/articles";
    }

    /*@GetMapping("/articles/content/{id}")
    public void showProductImage(@PathVariable Long id,
                               HttpServletResponse response) throws IOException {
        response.setContentType("text/plain"); // Or whatever format you wanna use

        byte[] content = artykulRepository.getContentById(id);

        InputStream is = new ByteArrayInputStream(product.getImage());
        IOUtils.copy(is, response.getOutputStream());
    }*/
    @GetMapping("/articles/archive/{id}")
    public String archive(@PathVariable("id") Long id, HttpSession session, Model model){
        artykulRepository.modifyState(id);
        //model.addAttribute("session", session);
        return "redirect:/articles";
    }
}