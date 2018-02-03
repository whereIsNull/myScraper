/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.nbastats.importer.nbastats.importer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author cristobal
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://stats.nba.com/scores/12/17/2010").get();
            Elements elements = doc.getAllElements();
            System.out.println(elements.html());
            elements = doc.getElementsByClass("linescores");
            System.out.println(elements.html());
            
            for(Element element: elements) {
                System.out.println(element.tagName() + ", id: " + element.id() + ", class: " + element.className() + ", cssSelector: " + element.cssSelector());
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
