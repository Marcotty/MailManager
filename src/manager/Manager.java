/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import admin.Client;
import static library.Mail_Library.EnvoyerMail;
import service.Service_Mailing;

/**
 *
 * @author fredm
 */
public class Manager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //EnvoyerMail("localhost");
        Service_Mailing mailing = new Service_Mailing();
        mailing.start();
        Client client = new Client();
        client.setVisible(true);
    }
    
}
