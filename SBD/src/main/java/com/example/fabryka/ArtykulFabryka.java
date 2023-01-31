/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.fabryka;

import com.example.entity.Artykul;
import com.example.entity.Publikacja;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author poker
 */
public class ArtykulFabryka implements PublikacjaFabryka
{
    @Override
    public Publikacja createPublikacja()
    {
        Artykul artykul = new Artykul();
        
        return artykul;
    }
    
    
}
