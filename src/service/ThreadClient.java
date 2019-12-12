/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fredm
 */
public class ThreadClient extends Thread{
    private Socket cliSocket;
    public ThreadClient(Socket cliSocket)
    {
        this.cliSocket = cliSocket;
    }
    @Override
    public void run()
    {
        while(!isInterrupted())
        {
            //TraiterRequete();
            
        }
    }

    private void Test() {
        OuvrirBoite();
    }

    private void OuvrirBoite() {
        Boite boite = new Boite();
        boite.setVisible(true);
    }

    private void TraiterRequete() {
        
        //RequeteMailing req = RecevoirRequete(cliSocket);
    }
}
