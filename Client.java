
package calendar;

import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Client {
    private Socket connection;
    private String serverAddress;
    private int port;
    private Formatter writer;
    private Scanner reader;
    
    public Client(String h, int p){
        serverAddress = h;
        port = p;
    }
    public void RunClient() throws IOException, ClassNotFoundException{
        try{
            connectToServer();
            getStreams();
        }
        catch (EOFException eofexcept){                  
        }
        finally{
            //closeConnection();
        }
    }
    private void connectToServer() throws IOException, ClassNotFoundException{
        try{
        connection = new Socket(InetAddress.getByName(serverAddress),port);
        }
        catch (IOException ex){
            int ch = JOptionPane.showConfirmDialog(null, "Unable to connect to the server, Retry connecting?");
            if(ch == JOptionPane.YES_OPTION){
                RunClient();
            }
            else
                System.exit(-1);
            }
        
        
        
    }
    private void getStreams() throws IOException{
        writer = new Formatter(connection.getOutputStream());
        writer.flush();
        reader = new Scanner(connection.getInputStream());   
    }

      private void closeConnection() throws IOException{
        
            writer.close();
            reader.close();
            connection.close();
    }
     public String recieveData(){
         String message = reader.next();
         return message;
     }
     public void sendData(String message) throws IOException{
        
            writer.format("%s",message);
            writer.flush();
        
    }
}
