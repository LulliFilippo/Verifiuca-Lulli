package it.fi.itismeucci.lulli;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Client client = new Client();
        while(true){
        client.connetti();
        client.comunica();
        }
    }
}
