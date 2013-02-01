
package calendar;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JFrame;

public class RunCalendar {

    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AskAddr dialog = new AskAddr(new JFrame(),true);
        
        dialog.setLocationRelativeTo(null);
        dialog.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent evt){
                System.exit(0);
            }
        });
        dialog.setVisible(true);
        String host = dialog.getAddress();
        
        int port = dialog.getPort();
        Client cl = new Client(host,port);
        cl.RunClient();
        Login login = new Login(cl);
        login.setSize(300, 150);
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*CalendarFrame frame = new CalendarFrame(null);
        frame.setVisible(true);
        frame.setSize(570,550);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
    }
}
