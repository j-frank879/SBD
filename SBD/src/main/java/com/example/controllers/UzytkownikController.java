package com.example.controllers;

import com.example.entity.Uzytkownik;
import com.example.repository.UzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UzytkownikController
{
    @Autowired
    private UzytkownikRepository uzytkownikRepository;

    @GetMapping("/users")
    public String getAll()
    {
        return("users");
    }

    @PostMapping("/users")
    public String saveUser(Uzytkownik uzytkownik)
    {
        uzytkownikRepository.save(uzytkownik);
        return("users");
    }
}
