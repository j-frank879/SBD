package com.example.controllers;


import com.example.repository.UzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class UzytkownikController {
    private UzytkownikRepository uzytkownikRepository;

    @GetMapping("/test")
    public String showTest() {

        return "test";
    }
    @GetMapping("/uzytkownik")
    public String showUserList(Model model) {
        model.addAttribute("users", uzytkownikRepository.findAll());
        return "uzytkownik";
    }



}