package com.example.controllers;

import com.example.controllers.adapter.ArtykulAdapter;
import com.example.entity.Notification;
import com.example.entity.UzytkSledz;
import com.example.entity.Uzytkownik;
import com.example.repository.ArtykulRepository;
import com.example.repository.NotificationRepository;
import com.example.repository.UzytkSledzRepository;
import com.example.repository.UzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UzytkownikController
{
    @Autowired
    private UzytkownikRepository uzytkownikRepository;
    @Autowired
    private ArtykulRepository artykulRepository;
    @Autowired
    private UzytkSledzRepository uzytkSledzRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @GetMapping("/add_subscription/{nazwa}")
    public String AddSubscription(@PathVariable("nazwa")String nazwa, HttpSession httpSession) {
        UzytkSledz uzytkSledz = new UzytkSledz();
        uzytkSledz.setNazwaUzytkownika(httpSession.getAttribute("username").toString());
        uzytkSledz.setUzytkownikSledzony(nazwa);
        uzytkSledzRepository.save(uzytkSledz);
        return("redirect:/articles");
    }

    @GetMapping("/user_list")
    public String UserList(HttpSession session, Model model) {
        try {
            List<Uzytkownik> users = uzytkownikRepository.findAll();

            model.addAttribute("users", users);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return("user_list");
    }

    @GetMapping("/signup")
    public String signUp(HttpSession httpSession, Model model) {
        model.addAttribute("user", new Uzytkownik());
        return("signup");
    }

    @PostMapping("/signup")
    public String signupUser(HttpSession httpSession, Uzytkownik uzytkownik)
    {
        uzytkownik.setRola(2);
        uzytkownik.setBlokada(false);
        uzytkownikRepository.save(uzytkownik);
        httpSession.setAttribute("username", uzytkownik.getNazwa());
        httpSession.setAttribute("role", uzytkownik.getRola());
        return("redirect:/articles");
    }

    @GetMapping("/login")
    public String loginPage(HttpSession httpSession)
    {
        return("login");
    }
    @PostMapping("/login")
    public String loginUser(HttpSession httpSession,
                            @RequestParam(value = "nazwa", required = true)String nazwa,
                            @RequestParam(value = "haslo", required = true)String password)
    {
        Uzytkownik uzytkownik = uzytkownikRepository.findBynazwa(nazwa);
        //String sessionId = sessionManager.createNewSession(uzytkownik.getNazwa()).toString(); //useless
        if (uzytkownik != null && password.equals(uzytkownik.getHaslo())) {
            httpSession.setAttribute("username", uzytkownik.getNazwa());
            httpSession.setAttribute("role", uzytkownik.getRola());
            return ("redirect:/articles");
        }
        else
            return("login");
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession httpSession)
    {
        httpSession.removeAttribute("username");
        httpSession.removeAttribute("role");
        return ("redirect:/articles");
    }

    @GetMapping("/user_page")
    public String userPage(HttpSession httpSession, Model model)
    {
        if(httpSession.getAttribute("username") != null){
            List<ArtykulAdapter> articles = new ArrayList<ArtykulAdapter>();
            artykulRepository.findBynazwaAutora(httpSession.getAttribute("username").toString()).forEach((art) -> {
            articles.add(new ArtykulAdapter(art));
            });
            model.addAttribute("articles", articles);
            model.addAttribute("notifications", notificationRepository.findAllBynazwaOdbiorcy(httpSession.getAttribute("username").toString()));
            return ("user_page");}
        else
            return ("redirect:/articles");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createAdmin()
    {
        Uzytkownik admin = uzytkownikRepository.findBynazwa("admin");
        if (admin == null || !(admin.getNazwa().equals("admin") && admin.getRola() == 0))
        {
            if (admin != null) uzytkownikRepository.deleteBynazwa("admin");

            admin = new Uzytkownik();
            admin.setNazwa("admin");
            admin.setHaslo("admin");
            admin.setBlokada(false);
            admin.setRola(0);
            admin.setEmail("admin@admin.com");
            uzytkownikRepository.save(admin);
        }
    }
}
