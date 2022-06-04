/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import edu.esprit.entities.Client;
import edu.esprit.entities.Coach;
import edu.esprit.entities.Moderateur;
import edu.esprit.entities.Pclub;
import edu.esprit.entities.Pterrain;
import edu.esprit.services.ClientService;
import edu.esprit.services.CoachService;
import edu.esprit.services.ModerateurService;
import edu.esprit.services.PclubService;
import edu.esprit.services.PterrainService;

/**
 *
 * @author Geekz
 */
public class EspritPremiaSports {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //Instanciating Of Services
        ClientService cs = new ClientService();
        CoachService coachs = new CoachService();
        ModerateurService ms = new ModerateurService();
        PclubService pcs = new PclubService();
        PterrainService pts = new PterrainService();
        
        //Client test instances
        Client c = new Client("Slimen", "OUNI");
        Client c1 = new Client(3,"Salma", "Ouni");
        
        //Client cupdate = new Client("EMNA", "OUNI");
        //Listing all users;
        //System.out.println(cs.listUsers());
        //Listing a User BY ID
        //System.out.println(cs.listUsersById(c));
        //Add User to DB
        //cs.addUser(c1);
        //Remove User from DB
       // cs.removeUser(c1);
        //Update User 
       //cs.updateUser(c1);
       
       
        


//        Coach test instances
//        Coach co = new Coach("AhmedBiceps", "123456", "Ahmed", "Ahmed");
//        Coach coupdate = new Coach("Ahmed", "9632", "Ahmed", "Ben foulen");
//         Listing all users;
//        System.out.println(coachs.listUsers());
//         Listing a User BY ID
//        System.out.println(coachs.listUsersById(1));
//        Add User to DB
//        coachs.addUser(co);
//        Remove User from DB
//        coachs.removeUser(1);
//        Update User 
//        coachs.updateUser(coupdate,1);
//        
//        Moderateur test instances
//        Moderateur md = new Moderateur("admin", "nimda", "Ali", "Salah") ;
//        Moderateur mdupdate = new Moderateur("sudo", "nimda", "Mohamed", "Salah") ;
//         Listing all users;
//        System.out.println(ms.listUsers());
//         Listing a User BY ID
//        System.out.println(ms.listUsersById(1));
//        Add User to DB
//        ms.addUser(md);
//        Remove User from DB
//        ms.removeUser(1);
//        Update User 
//        ms.updateUser(mdupdate,1);
//        
//        Pclub test instances
//        Pclub pc = new Pclub("maria123", "airam", "euro" , "ford");
//        Pclub pcupdate = new Pclub("cassandra321", "beverly", "euro" , "nissan");
//         Listing all users;
//        System.out.println(pcs.listUsers());
//         Listing a User BY ID
//        System.out.println(pcs.listUsersById(1));
//        Add User to DB
//        pcs.addUser(pc);
//        Remove User from DB
//        pcs.removeUser(1);
//        Update User 
//        pcs.updateUser(pcupdate,1);
//        
//        Pterrain test instances
//        Pterrain pt = new Pterrain("kyle123", "dollar", "alpha");
//        Pterrain ptupdate = new Pterrain("johnny", "dollar", "beta");
//         Listing all users;
//        System.out.println(pts.listUsers());
//         Listing a User BY ID
//        System.out.println(pts.listUsersById(1));
//        Add User to DB
//        pts.addUser(pt);
//        Remove User from DB
//        pts.removeUser(3);
//        Update User 
//         pts.updateUser(ptupdate,1);
        

    }
    
}
