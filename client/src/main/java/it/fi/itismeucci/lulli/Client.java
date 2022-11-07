package it.fi.itismeucci.lulli;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Client {
    BufferedReader tastiera;
    String ipServer = "127.0.0.1";
    int portaServer = 42069;
    DataOutputStream out;
    BufferedReader in;
    Socket socket;
    String stringaUtente;
    String stringaServer;
    
    protected void connetti(){
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            socket= new Socket(ipServer,portaServer);

            out= new DataOutputStream(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
        } catch (Exception e) {
            System.out.println("errore");
            System.exit(0);
        }
    }

    public void comunica(){
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(new Msg());

            System.out.println(xml);
            out.writeBytes(xml+'\n');
            
            stringaServer = in.readLine();
            System.out.println("risposta: "+ stringaServer);
            System.out.println("chiudo");
            socket.close();
        } catch (Exception e) {
            System.out.println("erroreee");
            System.exit(0);
        }
        
    }
}

