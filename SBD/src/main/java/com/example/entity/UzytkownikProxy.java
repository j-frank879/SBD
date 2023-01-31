/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entity;

import com.example.entity.IUzytkownik;
import com.example.entity.Uzytkownik;
import java.util.Date;

/**
 *
 * @author poker
 */
public class UzytkownikProxy implements IUzytkownik
{
    private Uzytkownik uzytkownik;
    private int licznikDzienny=0;
    private Date dataPierwszegoDodania;
    
    public UzytkownikProxy()
    {
        this.uzytkownik= new Uzytkownik();
        
    }
    public UzytkownikProxy(Uzytkownik uzytkownik)
    {
        this.uzytkownik= uzytkownik;
        
    }
    
    @Override
    public boolean dodajPiosenke() 
    {
        Date dataAktualna = new Date();
        if(licznikDzienny==0)
        {
            dataPierwszegoDodania= dataAktualna;
        }       
        if(dataAktualna.getTime()>dataPierwszegoDodania.getTime()+86400000) // minelo wiecej niz 24h (te 864 to 24h w milisekundach)
        {
            licznikDzienny=0;
            dataPierwszegoDodania=dataAktualna;
        }
        if(licznikDzienny<5)
        {
            
            licznikDzienny++;
            uzytkownik.dodajPiosenke();
        }
        else
        {
            //System.out.println("BLOKADA! Dodales juz za duzo piosenek!");
            return false;
        }
        return true;
        
    }
    
    
    
}
