package com.example.controllers;

import com.example.entity.Artykul;
import com.example.repository.ArtykulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArtykulController {

    @Autowired
    private ArtykulRepository artykulRepository;

    @GetMapping("/articles")
    public String getAll(Model model, @Param("keyword") String keyword) {
        try {
            List<Artykul> articles = new ArrayList<Artykul>();

            if (keyword == null) {
                artykulRepository.findAll().forEach(articles::add);
            } else {
                artykulRepository.findBynazwaContainingIgnoreCase(keyword).forEach(articles::add);
                model.addAttribute("keyword", keyword);
            }

            model.addAttribute("articles", articles);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "article_list";
    }

    @GetMapping("/articleEditor")
    public String main(Model model) {
        model.addAttribute("artykul", new Artykul());
        return "article_editor";
    }

    @PostMapping("/articleEditor")
    public String save(Artykul artykul, Model model) {
        model.addAttribute("artykul", artykul);
        artykulRepository.save(artykul);
        System.out.println(artykul.getId() + " " + artykul.getNazwa() + " " + artykul.getContent());
        System.out.println("save called");
        return "article_editor";
    }
}