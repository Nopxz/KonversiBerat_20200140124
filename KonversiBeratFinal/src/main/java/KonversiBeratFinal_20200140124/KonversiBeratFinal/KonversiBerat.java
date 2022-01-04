/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KonversiBeratFinal_20200140124.KonversiBeratFinal;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */
@Controller
public class KonversiBerat {
    private int beratpound(int getberatkilogram){
        int pounds = (int) (getberatkilogram * 2.20462);
        return pounds;
    }
    private int beratton(int getberatkilogram){
        int ton = (int) (getberatkilogram /1000);
        return ton;
    }
    
    private int beratons(int getberatkilogram){
        int ons = (int) (getberatkilogram *35.2739199982575);
        return ons;
    }
    
    private int beratgram(int getberatkilogram){
        int gram = (int) (getberatkilogram *1000);
        return gram;
    }
    
    private int beratkuintal(int getberatkilogram){
        int kuintal = (int) (getberatkilogram /100);
        return kuintal;
    }
    
    
    @RequestMapping("/berat")
    //@ResponseBody
    public String getHasil(HttpServletRequest data, Model databerat){
       String getnamaberat = data.getParameter("namaberat");
       int getberatkilogram = Integer.parseInt(data.getParameter("beratkilogram")); 
      
       int pound = beratpound(getberatkilogram);
       int ton = beratton(getberatkilogram);
       int ons = beratons(getberatkilogram);
       int gram = beratgram(getberatkilogram);
       int kuintal = beratkuintal(getberatkilogram);
       
       databerat.addAttribute("beratkilogram", getberatkilogram);
       databerat.addAttribute("beratpound", pound);
       databerat.addAttribute("beratton", ton);
       databerat.addAttribute("beratons", ons);
       databerat.addAttribute("beratgram", gram);
       databerat.addAttribute("beratkuintal", kuintal);
       
       return "tableviewer";
    }
}

