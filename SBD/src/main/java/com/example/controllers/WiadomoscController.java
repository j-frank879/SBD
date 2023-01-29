package com.example.controllers;


import com.example.entity.Publikacja;
import com.example.entity.Uzytkownik;
import com.example.entity.Wiadomosc;
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
public class WiadomoscController {
    @Autowired
private WiadomoscRepository wiadomoscRepository;
    @Autowired
    private UzytkownikRepository uzytkownikRepository;
    @GetMapping("/wiadomosc")
    public String getAll(HttpSession httpSession,Model model, @Param("keyword") String keyword) {
        String username= (String) httpSession.getAttribute("username");
        if(username==null)
            return "redirect:/login";
        try {
            List<Wiadomosc> wiadomosci = new ArrayList<Wiadomosc>();
            if (keyword == null) {
                wiadomoscRepository.findByNazwaOdbiorcyContainingIgnoreCase(username).forEach(wiadomosci::add);
            } else {
                wiadomoscRepository.findByNazwaNadawcyAndNazwaOdbiorcyContainingIgnoreCase(keyword,username).forEach(wiadomosci::add);
                model.addAttribute("keyword", keyword);
            }
            model.addAttribute("wiadomosci", wiadomosci);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "wiadomosc";
    }

    @GetMapping("/napisz_wiadomosc")
    public String addWiadomosc(HttpSession httpSession,Model model) {
        String username= (String) httpSession.getAttribute("username");
        if(username==null)
            return "redirect:/login";
        Wiadomosc wiadomosc = new Wiadomosc();

        model.addAttribute("wiadomosc", wiadomosc);

        model.addAttribute("pageTitle", "Napisz wiadomosc");

        return "napisz_wiadomosc";
    }

    @PostMapping("/wiadomosc/save")
    public String saveWiadomosc(Wiadomosc wiadomosc,HttpSession httpSession, RedirectAttributes redirectAttributes) {
        String username=(String) httpSession.getAttribute("username");
        Uzytkownik uzytkownik=uzytkownikRepository.findBynazwa(wiadomosc.getNazwaOdbiorcy());
        if(uzytkownik==null)
        {redirectAttributes.addFlashAttribute("message", "Nie ma użytkownika o podanej nazwie. Wiadomosc nie zostala wyslana.");
        return "redirect:/napisz_wiadomosc";}
        try {
            wiadomosc.setNazwaNadawcy(username);
            wiadomoscRepository.save(wiadomosc);

            redirectAttributes.addFlashAttribute("message", "Wiadomosc zostala wyslana");
        } catch (Exception e) {
            redirectAttributes.addAttribute("message", e.getMessage());
        }

        return "redirect:/wiadomosc";
    }
  @GetMapping("/wiadomosc/{id}")
  public String editWiadomosc(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
    try {
      Wiadomosc wiadomosc = wiadomoscRepository.findById(id).get();

      model.addAttribute("wiadomosc", wiadomosc);
      model.addAttribute("pageTitle", "Edytuj wiadomosc (ID: " + id + ")");

      return "napisz_wiadomosc";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());

      return "redirect:/wiadomosc";
    }
  }

    @GetMapping("/wiadomosc/delete/{id}")
    public String deleteWiadomosc(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            wiadomoscRepository.deleteById(id);

            redirectAttributes.addFlashAttribute("message", "Wiadomosc o id=" + id + " zostala  usunieta");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/wiadomosc";
    }
}





