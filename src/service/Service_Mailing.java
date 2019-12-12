/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fredm
 */
public class Service_Mailing extends Thread 
{
    
    private int PORT_MAILING;
    private ServerSocket serverSocket;
    public Service_Mailing()
    {
        
    }
    public void run()
    {
        PORT_MAILING = 50056;
        if(CreerServer())
        {
            while(true)
            {
                try 
                {
                    System.out.println("Accept client");
                    Socket cliSocket = serverSocket.accept();
                    ThreadClient client = new ThreadClient(cliSocket);
                    client.start();
                } 
                catch (IOException ex) 
                {
                    System.out.println("MAILING EXCEPTION | Accept serverSocket");
                    Logger.getLogger(Service_Mailing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private boolean CreerServer() {
        try 
        {
            serverSocket = new ServerSocket(PORT_MAILING);
            System.out.println("Creation server");
        } 
        catch (IOException ex) 
        {
            System.out.println("MAILING EXCEPTION | Creation serverSocket");
            Logger.getLogger(Service_Mailing.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
