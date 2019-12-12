/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.awt.List;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author fredm
 */
public class Mail_Library {
    
     public static void EnvoyerMailAttachementDigest(String host, String dest, String exp, String sujet, String message, String file) {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", host);
        prop.put("file.encoding", "iso-8859-1");
        
        try
        {
           System.out.println("Création du message"); 
           Session sess = Session.getDefaultInstance(prop, null);
           MimeMessage msg = new MimeMessage(sess);
           msg.setFrom(new InternetAddress(exp));
           msg.setRecipient(Message.RecipientType.TO, new InternetAddress(dest));
           msg.setSubject(sujet);

           System.out.println("Construction multipart");
           Multipart msgMP = new MimeMultipart();
           
           //1 texte d'accompagnement
           System.out.println("1ere compo :");
           MimeBodyPart msgBP = new MimeBodyPart();
           msgBP.setText(message);
           msgMP.addBodyPart(msgBP);
           
           //2 le fichier
           System.out.println("2e compo : fichier " + file);
           msgBP = new MimeBodyPart();
           DataSource so = new FileDataSource(file);
           msgBP.setDataHandler(new DataHandler(so));
           msgBP.setFileName(file);
           msgMP.addBodyPart(msgBP);
           
           msg.setContent(msgMP);
           //Création du digest 
           MessageDigest md = MessageDigest.getInstance("SHA-1", "BC");
           md.update(msg.toString().getBytes());
           byte[] msgD = md.digest();
           System.out.println("Envoi du message digest");
           
           System.out.println("Envoi du message");
           Transport.send(msg);
           System.out.println("Message envoyé a " + dest);
        }
        catch(MessagingException e)
        {
          System.out.println("Erreur sur envoi msg : " + e.getMessage());  
        }
        catch(NoSuchAlgorithmException e)
        {
            System.out.println("Erreur creation digest " + e.getMessage());
        } catch (NoSuchProviderException ex) {
            System.out.println("Erreur creation digest " + ex.getMessage());
         }
    }
   
    public static void EnvoyerMailAttachement(String host, String dest, String exp, String sujet, String message, String file) {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", host);
        prop.put("file.encoding", "iso-8859-1");
        
        try
        {
           System.out.println("Création du message"); 
           Session sess = Session.getDefaultInstance(prop, null);
           MimeMessage msg = new MimeMessage(sess);
           msg.setFrom(new InternetAddress(exp));
           msg.setRecipient(Message.RecipientType.TO, new InternetAddress(dest));
           msg.setSubject(sujet);

           System.out.println("Construction multipart");
           Multipart msgMP = new MimeMultipart();
           
           //1 texte d'accompagnement
           System.out.println("1ere compo :");
           MimeBodyPart msgBP = new MimeBodyPart();
           msgBP.setText(message);
           msgMP.addBodyPart(msgBP);
           
           //2 le fichier
           System.out.println("2e compo : fichier " + file);
           msgBP = new MimeBodyPart();
           DataSource so = new FileDataSource(file);
           msgBP.setDataHandler(new DataHandler(so));
           msgBP.setFileName(file);
           msgMP.addBodyPart(msgBP);
           
           msg.setContent(msgMP);
           System.out.println("Envoi du message");
           Transport.send(msg);
           System.out.println("Message envoyé a " + dest);
        }
        catch(MessagingException e)
        {
          System.out.println("Erreur sur envoi msg : " + e.getMessage());  
        }
    }
    public static void EnvoyerMail(String host, String dest, String exp, String sujet, String message)
    {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", host);
        
        try
        {
           System.out.println("Création du message"); 
           Session sess = Session.getDefaultInstance(prop, null);
           MimeMessage msg = new MimeMessage(sess);
           msg.setFrom(new InternetAddress(exp));
           msg.setRecipient(Message.RecipientType.TO, new InternetAddress(dest));
           msg.setSubject(sujet);
           msg.setText(message);
           
           System.out.println("Envoi du message");
           Transport.send(msg);
           System.out.println("Message envoyé a " + dest);
        }
        catch(MessagingException e)
        {
          System.out.println("Erreur sur envoi msg : " + e.getMessage());  
        }
    }
    public static void EnvoyerMail(String host) {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", host);
        
        try
        {
           System.out.println("Création du message");
           String exp = "test" + "@u2.tech.hepl.local";
           String dest = "info@test.com";
           String sujet = "test snmp";//"test smtp";
           String texte = "test1";
           
           Session sess = Session.getDefaultInstance(prop, null);
           MimeMessage msg = new MimeMessage(sess);
           msg.setFrom(new InternetAddress(exp));
           msg.setRecipient(Message.RecipientType.TO, new InternetAddress(dest));
           msg.setSubject(sujet);
           msg.setText(texte);
           
           System.out.println("Envoi du message");
           Transport.send(msg);
           System.out.println("Message envoyé a " + dest);
        }
        catch(MessagingException e)
        {
          System.out.println("Erreur sur envoi msg : " + e.getMessage());  
        }
    }
    public static int GetNombreMails(String host, String u, String p)
    {
        int count = 0;
        Properties prop = System.getProperties();
        System.out.println("SERVER MAILING | getNombreMails");
        prop.put("mail.pop3.host", host);
        prop.put("mail.disable.top", "true");
        Session sess = Session.getDefaultInstance(prop, null);
        //prop.list(System.out);
        String rep = null;
        try
        {
            //System.out.println("SERVER MAILING | Obtention d'un objet Store");
            Store st = sess.getStore("pop3");
            st.connect(host, u, p);

            //System.out.println("SERVER MAILING | Obtention d'un objet folder");
            Folder f = st.getFolder("INBOX");
            f.open(Folder.READ_ONLY);
            Message msg[] = f.getMessages();
            count = msg.length;
            f.close();
            st.close();
        }
        catch(MessagingException e)
        {
            System.out.println("SERVER MAILING MessagingException | Erreur sur provider : " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("SERVER MAILING Exception | Erreur sur provider : " + e.getMessage());
        }
        return count;
    }
    public static String OuvrirBoitePop3(String host, String u, String p)
    {
        Properties prop = System.getProperties();
        System.out.println("SERVER MAILING | Création de la session mail");
        prop.put("mail.pop3.host", host);
        prop.put("mail.disable.top", "true");
        Session sess = Session.getDefaultInstance(prop, null);
        //prop.list(System.out);
        String rep = "";
        try
        {
            //System.out.println("SERVER MAILING | Obtention d'un objet Store");
            Store st = sess.getStore("pop3");
            st.connect(host, u, p);

            //System.out.println("SERVER MAILING | Obtention d'un objet folder");
            Folder f = st.getFolder("INBOX");
            f.open(Folder.READ_ONLY);
            Message msg[] = f.getMessages();
            
            for(int i=msg.length-1; i >= 0; i--)
            {
                if (msg[i].isMimeType("text/plain")) 
                {
                    String sujet = msg[i].getSubject();
                    if(sujet == null)
                    {
                        rep += (String)msg[i].getContent();
                        rep += "|";
                        rep += msg[i].getFrom()[0];
                        rep += "#";
                    }
                    else
                    {
                        rep += sujet;
                        rep += "|";
                        rep += msg[i].getFrom()[0];
                        rep += "#";
                    }
                }
            }
            f.close();
            st.close();
        }
        catch(MessagingException e)
        {
            System.out.println("SERVER MAILING MessagingException | Erreur sur provider : " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("SERVER MAILING Exception | Erreur sur provider : " + e.getMessage());
        }
        
        return rep;
    }
    public static String GetMailsString(String host, String u, String p)
    {
        Properties prop = System.getProperties();
        System.out.println("SERVER MAILING | Création de la session mail");
        prop.put("mail.pop3.host", host);
        prop.put("mail.disable.top", "true");
        Session sess = Session.getDefaultInstance(prop, null);
        //prop.list(System.out);
        String rep = "";
        try
        {
            //System.out.println("SERVER MAILING | Obtention d'un objet Store");
            Store st = sess.getStore("pop3");
            st.connect(host, u, p);

            //System.out.println("SERVER MAILING | Obtention d'un objet folder");
            Folder f = st.getFolder("INBOX");
            f.open(Folder.READ_ONLY);
            Message msg[] = f.getMessages();
            
            for(int i=msg.length-1; i >= 0; i--)
            {
                if (msg[i].isMimeType("text/plain")) 
                {
                    String sujet = msg[i].getSubject();
                    if(sujet == null)
                    {
                        rep += (String)msg[i].getContent();
                        rep += "|";
                        rep += msg[i].getFrom()[0];
                        rep += "#";
                    }
                    else
                    {
                        rep += sujet;
                        rep += "|";
                        rep += msg[i].getFrom()[0];
                        rep += "#";
                    }
                }
                else
                {
                    if(msg[i].getSubject() != null)
                    {
                        System.out.println("Message avec piece jointe : " + msg[i].getSubject());
                        rep += msg[i].getSubject();
                        rep += "|";
                        rep += msg[i].getFrom()[0];
                        rep += "#";
                    }        
                    
                    //Recup multipart
                   Multipart msgMP = (Multipart)msg[i].getContent();
                   int np = msgMP.getCount();
                   //System.out.println("nombre de composantes : " + np);

                    //scan body parts
                    for(int j=0; j<np; j++)
                    {
                        System.out.println("Compo " + j);
                        Part pa = msgMP.getBodyPart(j);
                        String d = pa.getDisposition();
                        if(pa.isMimeType("text/plain"))
                            System.out.println("Texte : " + (String)pa.getContent());
                        if(d != null && d.equalsIgnoreCase(Part.ATTACHMENT))
                        {
                            InputStream is = pa.getInputStream();
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            int c;
                            while((c = is.read()) != -1) 
                                baos.write(c);
                            baos.flush();
                            String nf = pa.getFileName();
                            FileOutputStream fos = new FileOutputStream(nf);
                            baos.writeTo(fos);
                            fos.close();
                            System.out.println("Piece attachee " + nf + " recuperee");
                        }
                    }
                }
            }
            System.out.println("Fin des messages");
            f.close();
            st.close();
        }
        catch(MessagingException e)
        {
            System.out.println("SERVER MAILING2 MessagingException | Erreur sur provider : " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("SERVER MAILING2 Exception | Erreur sur provider : " + e.getMessage());
        }
        
        return rep;
    }
    public static String[] getInfosMails(String host, String u, String p, String mailOpen)
    {
        Properties prop = System.getProperties();
        System.out.println("SERVER MAILING | getInfosMails");
        prop.put("mail.pop3.host", host);
        prop.put("mail.disable.top", "true");
        Session sess = Session.getDefaultInstance(prop, null);
        //prop.list(System.out);
        String rep = "";
        String[] infos = null;
        try
        {
            //System.out.println("SERVER MAILING | Obtention d'un objet Store");
            Store st = sess.getStore("pop3");
            st.connect(host, u, p);

            //System.out.println("SERVER MAILING | Obtention d'un objet folder");
            Folder f = st.getFolder("INBOX");
            f.open(Folder.READ_ONLY);
            Message msg[] = f.getMessages();
            
            for(int i=msg.length-1; i >= 0; i--)
            {
                if (msg[i].isMimeType("text/plain")) 
                {
                    String sujet = msg[i].getSubject();
                    if(sujet == null)
                    {
                        rep += (String)msg[i].getContent();
                        rep += "|";
                        rep += msg[i].getFrom()[0];
                        rep += "#";
                    }
                    else
                    {
                        rep += sujet;
                        rep += "|";
                        rep += msg[i].getFrom()[0];
                        rep += "#";
                    }
                }
                else
                {
                    if(msg[i].getSubject() != null)
                    {
                        //System.out.println("Message avec piece jointe : " + msg[i].getSubject());
                        rep += msg[i].getSubject();
                        rep += "|";
                        rep += msg[i].getFrom()[0];
                        rep += "#";
                    }        
                    
                    //Recup multipart
                   Multipart msgMP = (Multipart)msg[i].getContent();
                   int np = msgMP.getCount();
                   //System.out.println("nombre de composantes : " + np);

                    //scan body parts
                    for(int j=0; j<np; j++)
                    {
                        //System.out.println("Compo " + j);
                        Part pa = msgMP.getBodyPart(j);
                        String d = pa.getDisposition();
                        //if(pa.isMimeType("text/plain"))
                            //System.out.println("Texte : " + (String)pa.getContent());
                        if(d != null && d.equalsIgnoreCase(Part.ATTACHMENT))
                        {
                            InputStream is = pa.getInputStream();
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            int c;
                            while((c = is.read()) != -1) 
                                baos.write(c);
                            baos.flush();
                            String nf = pa.getFileName();
                            FileOutputStream fos = new FileOutputStream(nf);
                            baos.writeTo(fos);
                            fos.close();
                            //System.out.println("Piece attachee " + nf + " recuperee");
                        }
                    }
                }
                //check mailOpen == mail lu
                System.out.println("check : " + mailOpen + " et " + rep);
                
            }
            System.out.println("Fin des messages");
            f.close();
            st.close();
        }
        catch(MessagingException e)
        {
            System.out.println("SERVER MAILING2 MessagingException | Erreur sur provider : " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("SERVER MAILING2 Exception | Erreur sur provider : " + e.getMessage());
        }
        
        return infos;
    }
    public static Mail getInfosMails(int id)
    {
        Mail mail = new Mail();
        
       return mail;   
    }
    public static ArrayList<Object> getMails(String host, String u, String p)
    {
        ArrayList<Object> listMails = new ArrayList<>();
        Properties prop = System.getProperties();
        System.out.println("SERVER MAILING | getMails");
        prop.put("mail.pop3.host", host);
        prop.put("mail.disable.top", "true");
        Session sess = Session.getDefaultInstance(prop, null);
        
        try
        {
            //System.out.println("SERVER MAILING | Obtention d'un objet Store");
            Store st = sess.getStore("pop3");
            st.connect(host, u, p);

            //System.out.println("SERVER MAILING | Obtention d'un objet folder");
            Folder f = st.getFolder("INBOX");
            f.open(Folder.READ_ONLY);
            Message msg[] = f.getMessages();
            
            for(int i=msg.length-1; i >= 0; i--)
            {
                Mail mail = new Mail();
                if (msg[i].isMimeType("text/plain")) 
                {
                    String sujet = msg[i].getSubject();
                    if(sujet == null)
                    {
                        mail.setText((String)msg[i].getContent());
                        String from = "";
                        from += msg[i].getFrom()[0];
                        mail.setFrom(from);
                    }
                    else
                    {
                        String from = "";
                        from += msg[i].getFrom()[0];
                        mail.setFrom(from);
                        mail.setSubject(msg[i].getSubject());
                        mail.setText((String)msg[i].getContent());
                    }
                }
                else
                {
                    if(msg[i].getSubject() != null)
                    {
                        System.out.println("Message avec piece jointe : " + msg[i].getSubject());
                        String from = "";
                        from += msg[i].getFrom()[0];
                        mail.setFrom(from);
                        mail.setSubject(msg[i].getSubject());
                        
                    }
                    else
                    {
                        String from = "";
                        from += msg[i].getFrom()[0];
                        mail.setFrom(from);
                    }
                    
                    //Recup multipart
                   Multipart msgMP = (Multipart)msg[i].getContent();
                   int np = msgMP.getCount();
                   //System.out.println("nombre de composantes : " + np);

                    //scan body parts
                    for(int j=0; j<np; j++)
                    {
                        //System.out.println("Compo " + j);
                        Part pa = msgMP.getBodyPart(j);
                        String d = pa.getDisposition();
                        //if(pa.isMimeType("text/plain"))
                            //System.out.println("Texte : " + (String)pa.getContent());
                        if(d != null && d.equalsIgnoreCase(Part.ATTACHMENT))
                        {
                            InputStream is = pa.getInputStream();
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            int c;
                            while((c = is.read()) != -1) 
                                baos.write(c);
                            baos.flush();
                            String nf = pa.getFileName();
                            FileOutputStream fos = new FileOutputStream(nf);
                            baos.writeTo(fos);
                            fos.close();
                            mail.setFileName(nf);
                            System.out.println("Piece attachee " + nf + " recuperee");
                        }
                    }
                }
                listMails.add(mail);
            }
            System.out.println("Fin des messages");
            f.close();
            st.close();
        }
        catch(MessagingException e)
        {
            System.out.println("SERVER MAILING2 MessagingException | Erreur sur provider : " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("SERVER MAILING2 Exception | Erreur sur provider : " + e.getMessage());
        }
        
        return listMails;
    }
    public static Boolean DownloadAttachement(String host, String u, String p, String filename, String filedest)
    {
        Properties prop = System.getProperties();
        System.out.println("SERVER MAILING | getMails");
        prop.put("mail.pop3.host", host);
        prop.put("mail.disable.top", "true");
        Session sess = Session.getDefaultInstance(prop, null);
        
        try
        {
            //System.out.println("SERVER MAILING | Obtention d'un objet Store");
            Store st = sess.getStore("pop3");
            st.connect(host, u, p);

            //System.out.println("SERVER MAILING | Obtention d'un objet folder");
            Folder f = st.getFolder("INBOX");
            f.open(Folder.READ_ONLY);
            Message msg[] = f.getMessages();
            
            for(int i=msg.length-1; i >= 0; i--)
            {
                if (msg[i].isMimeType("text/plain")) 
                {}
                else
                {   
                    //Recup multipart
                   Multipart msgMP = (Multipart)msg[i].getContent();
                   int np = msgMP.getCount();
                   //System.out.println("nombre de composantes : " + np);

                    //scan body parts
                    for(int j=0; j<np; j++)
                    {
                        //System.out.println("Compo " + j);
                        Part pa = msgMP.getBodyPart(j);
                        String d = pa.getDisposition();
                        //if(pa.isMimeType("text/plain"))
                            //System.out.println("Texte : " + (String)pa.getContent());
                        if(d != null && d.equalsIgnoreCase(Part.ATTACHMENT))
                        {
                            InputStream is = pa.getInputStream();
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            int c;
                            while((c = is.read()) != -1) 
                                baos.write(c);
                            baos.flush();
                            String nf = pa.getFileName();
                            FileOutputStream fos = new FileOutputStream(nf);
                            baos.writeTo(fos);
                            //fos.close();
                            
                            //Téléchargement fichier
                            if(nf.equals(filename))
                            {
                                File file;
                                try
                                {
                                    System.out.println("TEST " + nf + " et " + filedest);
                                    file = new File(filedest);
                                    fos = new FileOutputStream(filedest);
                                    baos.writeTo(fos);
                                    if(!file.exists())
                                    {
                                        file.createNewFile();
                                    }
                                    byte[] contentBytes = baos.toByteArray();
                                    fos.write(contentBytes);
                                    fos.flush();
                                    fos.close();
                                    
                                    System.out.println("Done");
                                    System.out.println("Piece attachee " + nf + " telechargee");

                                }
                                catch(IOException e)
                                {
                                    e.printStackTrace();
                                    fos.close();
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("Fin des messages");
            f.close();
            st.close();
        }
        catch(MessagingException e)
        {
            System.out.println("SERVER MAILING2 MessagingException | Erreur sur provider : " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("SERVER MAILING2 Exception | Erreur sur provider : " + e.getMessage());
        }
        return true;
    }
}
