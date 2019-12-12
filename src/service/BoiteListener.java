/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import static library.Mail_Library.GetNombreMails;
import static library.Mail_Library.OuvrirBoitePop3;
import static library.Mail_Library.getMails;

/**
 *
 * @author fredm
 */
public class BoiteListener extends Thread{
    private int number = 0;
    private JList LMails;
    private String host;
    private String user;
    private String pass;
    private ArrayList<Object> listMails;
    private Boite parent;
    BoiteListener(String host, String user, String pass, JList LMails, ArrayList<Object> listM, Boite parent) {
        this.host = host;
        this.LMails= LMails;
        listMails = listM;
        this.parent = parent;
        this.user = user;
        this.pass = pass;
    }
    public synchronized void run()
    {
        System.out.println("Lancement du listener");
        number = GetNombreMails(host, user, pass);
        while(!isInterrupted())
        {
            if(number != GetNombreMails(host, user, pass))
            {
                /* String mails = OuvrirBoitePop3("localhost", "info@test.com", "user");
                if(mails != null)
                {
                    Vector vect = new Vector();
                    StringTokenizer parser = new StringTokenizer(mails, "#");
                    while(parser.hasMoreTokens())
                        vect.add(parser.nextToken());

                    LMails.setListData(vect);
                }*/
                listMails = getMails(host, user, pass);
                ListToFields(listMails);
                parent.setListMails(listMails);
            }
            try {
                wait(1000 * 20);
            } catch (InterruptedException ex) {
                Logger.getLogger(BoiteListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void ListToFields(ArrayList<Object> listMails) {
        Vector<String> listString = MailsToString(listMails);
        LMails.setListData(listString);
    }
    private Vector<String> MailsToString(ArrayList<Object> listMails) {
        Vector<String> vect = new Vector();
        for(int i=0; i< listMails.size(); i++)
        {
            vect.add(listMails.get(i).toString());
        }
        return vect;
    }
}
