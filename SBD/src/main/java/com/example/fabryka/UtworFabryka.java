/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.fabryka;

import com.example.entity.Publikacja;
import com.example.entity.Utwor;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author poker
 */
public class UtworFabryka implements PublikacjaFabryka {

    @Override
    public Publikacja createPublikacja() 
    {
        Utwor utwor = null;
        try {
            utwor = new Utwor();
        } catch (MalformedURLException ex) {
            Logger.getLogger(UtworFabryka.class.getName()).log(Level.SEVERE, null, ex);
        }
        return utwor;
    }
    
}
