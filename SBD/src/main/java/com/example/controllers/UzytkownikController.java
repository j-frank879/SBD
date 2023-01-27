package com.example.controllers;

import com.example.SessionManager;
import com.example.entity.Artykul;
import com.example.entity.Uzytkownik;
import com.example.repository.UzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class UzytkownikController
{
    @Autowired
    private UzytkownikRepository uzytkownikRepository;
    @Autowired
    private SessionManager sessionManager; //useless

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("user", new Uzytkownik());
        return("signup");
    }
    @GetMapping("/users")
    public String getAll()
    {
        return("users");
    }

    @PostMapping("/signup")
    public String signupUser(HttpSession httpSession, Uzytkownik uzytkownik)
    {
        uzytkownikRepository.save(uzytkownik);
        //String sessionId = sessionManager.createNewSession(uzytkownik.getNazwa()).toString(); //useless
        httpSession.setAttribute("sessionId", UUID.randomUUID());
        return("redirect:/articles");
    }
}
