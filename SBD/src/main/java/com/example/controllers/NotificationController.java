package com.example.controllers;


import com.example.entity.Uzytkownik;
import com.example.entity.Wiadomosc;
import com.example.repository.NotificationRepository;
import com.example.repository.UzytkownikRepository;
import com.example.repository.WiadomoscRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UzytkownikRepository uzytkownikRepository;


    @GetMapping("/notification/delete/{id}")
    public String deleteNotification(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            notificationRepository.deleteById(id);

            redirectAttributes.addFlashAttribute("message", "Powiadomienie o id=" + id + " zostala  usunieta");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/user_page";
    }
}





