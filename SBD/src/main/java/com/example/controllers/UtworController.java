/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controllers;
import com.example.entity.Publikacja;
import com.example.entity.Utwor;
import com.example.fabryka.UtworFabryka;
import com.example.repository.UtworRepository;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author poker
 */
@Controller
public class UtworController 
{
  @Autowired
  private UtworRepository utworRepository;
  private UtworFabryka fabrykaUtworow = new UtworFabryka();
  

  @GetMapping("/utwory")
  public String getAll(HttpSession httpSession,Model model, @Param("keyword") String keyword) {
    try {
      
      List<Publikacja> utwory = new ArrayList<Publikacja>();

      
      if (keyword == null) {
        utworRepository.findAll().forEach(utwory::add);
      } else {
        utworRepository.findByNazwaContainingIgnoreCase(keyword).forEach(utwory::add);
        model.addAttribute("keyword", keyword);
      }
      

      
      model.addAttribute("utwory", utwory);
      
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }
    

    return "utwory";
  }

  @GetMapping("/utwory/new")
  public String addUtwor(HttpSession httpSession,Model model) throws MalformedURLException {
      
        String username= (String) httpSession.getAttribute("username");
        
        if(username==null)
            return "redirect:/login";
    Publikacja utwor = fabrykaUtworow.createPublikacja();
    
    
    model.addAttribute("utwor", utwor);
    model.addAttribute("pageTitle", "Dodaj nowy utwor");

    return "utwor_form";
  }

  @PostMapping("/utwory/save")
  public String saveUtwor(Utwor utwor,HttpSession httpSession, RedirectAttributes redirectAttributes) {
    try {
        String username=(String) httpSession.getAttribute("username");
      utwor.setnazwaAutora(username);
      utworRepository.save(utwor);

      redirectAttributes.addFlashAttribute("message", "Udalo sie dodac utwor! Brawo!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
    }

    return "redirect:/utwory";
  }
  @GetMapping("/utwory/{id}")
  public String editUtwor(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
    try {
      Publikacja utwor = utworRepository.findById(id).get();

      model.addAttribute("utwor", utwor);
      model.addAttribute("pageTitle", "Edytuj utwor (ID: " + id + ")");

      return "utwor_form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());

      return "redirect:/utwory";
    }
  }

  @GetMapping("/utwory/delete/{id}")
  public String deleteUtwor(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
    try {
      utworRepository.deleteById(id);

      redirectAttributes.addFlashAttribute("message", "Utwor o id=" + id + " zostal usuniety");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/utwory";
  }
  
  
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
        throws ServletException 
    {

        // Convert multipart object to byte[]
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());

    }

    
}
