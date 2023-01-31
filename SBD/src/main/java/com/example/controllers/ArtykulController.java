package com.example.controllers;

import com.example.controllers.adapter.ArtykulAdapter;
import com.example.controllers.iterator.BackwardIterator;
import com.example.controllers.iterator.ForwardIterator;
import com.example.entity.Artykul;
import com.example.entity.Notification;
import com.example.entity.UzytkSledz;
import com.example.repository.ArtykulRepository;
import com.example.repository.NotificationRepository;
import com.example.repository.UzytkSledzRepository;
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
import java.util.*;

@Controller
public class ArtykulController {

    @Autowired
    private ArtykulRepository artykulRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UzytkSledzRepository uzytkSledzRepository;
    @GetMapping("/")
    public String mainRedirect() {return "redirect:/articles";}

    @GetMapping("/articles")
    public String getAll(HttpSession session, Model model, @Param("keyword") String keyword) {
        try {
            List<ArtykulAdapter> articles = new ArrayList<ArtykulAdapter>();

            if (keyword == null) {
                artykulRepository.findAll().forEach((art) -> {
                    articles.add(new ArtykulAdapter(art));
                });
            } else {
                artykulRepository.findBynazwaContainingIgnoreCase(keyword).forEach((art) -> {
                    articles.add(new ArtykulAdapter(art));
                });
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

            model.addAttribute("artykul", new ArtykulAdapter(article.get()));
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
        if ((Integer)session.getAttribute("role") < 2) {
            artykul.setnazwaAutora(session.getAttribute("username").toString());
            artykul.setdataPrzeslania(new Date());
            model.addAttribute("artykul", new ArtykulAdapter(artykul));
            //model.addAttribute("session", session);
            artykulRepository.save(artykul);
            SendNotifications(session.getAttribute("username").toString(), "Użytnik "+session.getAttribute("username").toString()+" wstawił artykuł.");
            System.out.println(artykul.getId() + " " + artykul.getNazwa() + " " + artykul.getContent());
            System.out.println("save called");
        }
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
    public void SendNotifications(String sender, String text) {
        Iterator<UzytkSledz> iterator = subscriptionIterator(uzytkSledzRepository.findAllByuzytkownikSledzony(sender)) ;
        while(iterator.hasNext()){
            notificationRepository.save(new Notification(text,sender,iterator.next().getNazwaUzytkownika()));
        }
    }

    public Iterator<Artykul> artykulIterator () {
        Random rnd = new Random();
        switch (rnd.nextInt(2)) {
            case 0:
                return new ForwardIterator<Artykul>(artykulRepository.findAll());
            case 1:
                return new BackwardIterator<Artykul>(artykulRepository.findAll());
        }
        return null;
    }

    public Iterator<UzytkSledz> subscriptionIterator (List<UzytkSledz> list) {
        Random rnd = new Random();
        switch (rnd.nextInt(2)) {
            case 0:
                return new ForwardIterator<UzytkSledz>(list);
            case 1:
                return new BackwardIterator<UzytkSledz>(list);
        }
        return null;
    }
}