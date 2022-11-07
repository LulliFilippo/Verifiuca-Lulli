package it.fi.itismeucci.lulli;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Server extends Thread{
    ServerSocket server = null;
    Socket client = null;
    String strRicevuta;
    String strModificata;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    
    ArrayList<Socket> clients = new ArrayList<Socket>();
    ArrayList<Biglietto> Biglietti = new ArrayList<Biglietto>();

public void aggiunta(){
    Biglietto b1 = new Biglietto(1, "palco");
    Biglietto b2 = new Biglietto(2, "palco");
    Biglietto b3 = new Biglietto(3, "palco");
    Biglietto b4 = new Biglietto(4, "palco");
    Biglietto b5 = new Biglietto(5, "palco");
    Biglietto b6 = new Biglietto(6, "palco");
    Biglietto b7 = new Biglietto(7, "palco");
    Biglietto b8 = new Biglietto(8, "palco");
    Biglietto b9 = new Biglietto(9, "palco");
    Biglietto b10 = new Biglietto(10, "palco");

    Biglietti.add(b1);
    Biglietti.add(b2);
    Biglietti.add(b3);
    Biglietti.add(b4);
    Biglietti.add(b5);
    Biglietti.add(b6);
    Biglietti.add(b7);
    Biglietti.add(b8);
    Biglietti.add(b9);
    Biglietti.add(b10);
}

    public void connetti() throws IOException {
        if (server == null) {
            System.out.println("server partito");
            server = new ServerSocket(42069);
        }
        client = server.accept();
        System.out.println("socket connesso");
        // server.close();
        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());
        comunica();
    }

    public void comunica() throws IOException {
        strRicevuta = inDalClient.readLine();

        //DESERIALIAZZAZIONE DEL MESSAGGIO INIZIALE DEL CLIENT
        XmlMapper xmlMapper = new XmlMapper();
        Biglietto value = xmlMapper.readValue(strRicevuta, Biglietto.class);
        System.out.println("stringa ricevuta: " + strRicevuta);

        //SERIALIZZAZIONE DELLA LISTA DEI BIGLIETTI DISPONIBILI + INVIO AL CLIENT
        String xml = xmlMapper.writeValueAsString(new Msg());
        outVersoClient.writeBytes(xml+'\n');


        strModificata = strRicevuta.toUpperCase();
        outVersoClient.writeBytes(strModificata + '\n');
        System.out.println("stringa inviata");
        client.close();
        connetti();
    }
}
