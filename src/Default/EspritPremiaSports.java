/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import edu.esprit.entities.categories;
import edu.esprit.entities.commandes;
import edu.esprit.entities.produits;
import edu.esprit.services.categorieService;
import edu.esprit.services.commandeService;
import edu.esprit.services.produitService;
import edu.esprit.utils.MyConnection;

/**
 *
 * @author Geekz
 */public class EspritPremiaSports {

  
    public static void main(String[] args) {
        // app connex done
        
       MyConnection.getInstance();
        MyConnection.getInstance();
        
        produitService ps = new produitService();
       categorieService cs = new categorieService ();
       commandeService cmd = new commandeService ();
        
        
        
        produits p = new produits("Iphone 13","hello");
        
                produits p2 = new produits("Iphone 11 ","Hi");
                ps.ajouterproduits(p2);

          ps.ajouterproduits(p) ;
       
        categories c = new categories ("test","Informatique");
           cs.ajouterCategories(c);
           
           
           
           commandes c1 = new commandes  ("test","Informatique");
           cmd.ajouterCommande(c1);
        
    
    cs.effacer();
      //cs.getCategoryByID(5);
      
      cs.effacer();
      cs.ajouterCategories(c);
      cs.select(2, 2);
        
        cs.updatecat();
        
        
      
    }
    
}
