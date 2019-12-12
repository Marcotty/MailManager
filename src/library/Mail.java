/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author fredm
 */
public class Mail {
    private String To;
    private String From;
    private String Subject;
    private String Text;
    private String FileName;
    public Mail()
    {
        To = null;
        From = null;
        Subject = null;
        Text = null;
        FileName = null;
    }
    public Mail(String to, String from, String sub, String t, String f)
    {
        To = to;
        From = from;
        Subject = sub;
        Text = t;
        FileName = f;
    }
    public String getTo()
    {
        return To;
    }
    public String getFrom()
    {
        return From;
    }
    public String getSubject()
    {
        return Subject;
    }
    public String getText()
    {
        return Text;
    }
    public String getFileName()
    {
        return FileName;
    }
    public void setTo(String s)
    {
        To = s;
    }
    public void setFrom(String s)
    {
        From = s;
    }
    public void setSubject(String s)
    {
        Subject = s;
    }
    public void setText(String s)
    {
        Text = s;
    }
    public void setFileName(String s)
    {
        FileName = s;
    }
    @Override
    public String toString()
    {
        if(FileName == null)
        {
            if(Subject == null)
                return getFrom() + "    " + getText();
            else
                return getFrom() + "    " + getSubject();
        }
        else
        {
            if(Subject == null)
                return getFrom() + "    " + getText() + "    " + getFileName();
            else
                return getFrom() + "    " + getSubject() + "    " + getFileName();
        }
    }
}
