package it.fi.itismeucci.lulli;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Server server = new Server();
        try {
            server.connetti();
            server.comunica();
        } catch (Exception e) {}
    }
}
