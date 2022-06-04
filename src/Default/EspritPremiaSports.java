
package Default;

import edu.esprit.entities.Categories;
import edu.esprit.entities.Commandes;
import edu.esprit.entities.Produits;
import edu.esprit.services.CategorieService;
import edu.esprit.services.CommandeService;
import edu.esprit.services.ProduitService;
import edu.esprit.utils.MyConnection;

/**
 *
 * @author Geekz
 */public class EspritPremiaSports {

    public static void main(String[] args) {
        // app connex done 
        
   MyConnection.getInstance();


   
   //********CATEGORIES******************
// 1) INSERT DANS CATEGORIES done
 //CategorieService cat = new CategorieService ();
//Categories categroeis = new Categories ("FOOTBALL","TEST");
//Categories categroeis2 = new Categories ("Tennis","TEST2");
//cat.insertCategories(categroeis2);
 
    
 //2) UPDATE CATEGORIES done
      //CategorieService gs = new CategorieService();
        //Categories c = new Categories(225,"RAQUETTE2222222");
        //gs.updatecat(c);
      
        

     
//3) DELETE CATEGORIES done
  //CategorieService dl = new CategorieService();
  //Categories dlsup = new Categories(225,"RAQUETTE2222222");

        //dl.DeleteCategories(dlsup);
      







        
  //4) GET BY ID DONE 
  //CategorieService gs1 = new CategorieService();
        //Categories c1 = new Categories(5,"TEST");
        //gs1.getCategoryByID(c1);
        
        
        
        
        
  //5) SELECT ALL * DONE 
  
  //CategorieService gs2 = new CategorieService();
        //Categories c2 = new Categories(5,"TEST");
       //gs2.selectall();
       
       
       
       
       //********COMMANDES ******************
       
     // 1) INSERT DANS COMMANDES done  
       
        //CommandeService cmd = new CommandeService ();
//Commandes cm = new Commandes ("ETAT OK ","B1108MO");
//cmd.insertCommandes(cm);
       
       
         
 //2) UPDATE COMMANDES done
      //CommandeService cmd1 = new CommandeService ();
        //Commandes cm1 = new Commandes (1,"ETAT KO ");
        //cmd1.updatecommande(cm1);
       
    //3) DELETE Commandes done
  //CommandeService ccmd = new CommandeService();
  //Commandes cmdsup = new Commandes(225,"RAQUETTE2222222");

        //ccmd.DeleteCommandes(cmdsup);
       
       
       
        //4) GET BY ID DONE 
  //CommandeService gc = new CommandeService ();
        //Commandes cm2 = new Commandes(5,"ok");
        //gc.getCategoryByID(cm2);
       
        //5) SELECT ALL * DONE 
  
  //CommandeService cmdd = new CommandeService();
        //Commandes c2 = new Commandes(5,"ok");
       //cmdd. selectAllaCommandes();
       

       
         //********PRODUITS******************
         
         // 1) INSERT DANS Produit
//ProduitService prd = new ProduitService ();
//Produits prod = new Produits ("Ballon","bel.jpg", 65);
//prd.insertProduits(prod);

  
//OU BIEN  ********************

        //SERVICES *************************
        
        //CategorieService cs = new CategorieService();
        //ProduitService ps = new ProduitService();
        
        //instanciate *****************************
        //Categories c = new Categories ("Tennis","TEST2");
         //cs.insertCategories (c);
        //Produits pp= new Produits ("Ballon","bel.jpg", 65, c);
               //INSERT PRODUIT add Produit ***************************************
        //ps.insertProduits(pp);
 



 //2) UPDATE PRODUITS done
      //ProduitService prd1 = new ProduitService ();
        //Produits prod1 = new Produits (1,"BallonOR  ");
        //prd1.updateProduit(prod1);
        
           //3) DELETE PRODUITS done
  //ProduitService prdd = new ProduitService();
  //Produits pdrsup = new Produits (225,"RAQUETTE2222222");

        //prdd.DeleteProduits(pdrsup);
        
        
             //4) GET BY ID DONE 
  //ProduitService prd2 = new ProduitService ();
        //Produits prod2 = new Produits (5,"Ballon");
        //prd2.getProduitByID(prod2);
        
        
        
        
        
        
            //5) SELECT ALL * DONE 
  
  //ProduitService prd3 = new ProduitService();
        //Produits pr = new Produits (5,"ok");
      //prd3.selectAllaProduits();
        
    }
    
}
