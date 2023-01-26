/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entity;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author poker
 */
public class UtworProxy implements IUtwor
{
    private Utwor realUtwor=null;
    
    public UtworProxy() throws MalformedURLException
    {
        
    }

    @Override
    public Long getId() {
        if(realUtwor==null)
        {
            return null;
        }
        return realUtwor.getId();
    }

    @Override
    public String getOpis() 
    {
        if(realUtwor==null)
        {
            return null;
        }
        return realUtwor.getOpis();
    }

    @Override
    public byte[] getUtwor()
    {
         if(realUtwor==null)
        {
            return null;
        }
        return realUtwor.getUtwor();
        
    }

    @Override
    public void setId(Long Id) {
         if(realUtwor==null)
        {
             try {
                 realUtwor = new Utwor();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(UtworProxy.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        realUtwor.setId(Id);
        
    }

    @Override
    public void setOpis(String opis)
    {
        if(realUtwor==null)
        {
             try {
                 realUtwor = new Utwor();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(UtworProxy.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        realUtwor.setOpis(opis);
    }

    @Override
    public void setUtwor(byte[] utwor) 
    {
        if(realUtwor==null)
        {
             try {
                 realUtwor = new Utwor();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(UtworProxy.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        realUtwor.setUtwor(utwor);
    }
    
    
}
