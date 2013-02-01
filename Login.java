package calendar;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Login extends JFrame {
    private JLabel userName;
    private JLabel password;
    private JTextField name;
    private JPasswordField pass;
    private JButton login;
    private JButton newuser;
    private Client client;
    private String serverAdd;
    
    public Login(Client cl){
        super("Login to your account");
        setLocationRelativeTo(null);
        client = cl;
        userName = new JLabel("Username: ");
        userName.setFont(new Font("Sogue UI",Font.PLAIN,12));
        password = new JLabel("Password: ");
        password.setFont(new Font("Sogue UI",Font.PLAIN,12));
        name = new JTextField("");
        pass = new JPasswordField("");
        login = new JButton("Sign In");
        newuser = new JButton("New User Signup");
        GridLayout grid = new GridLayout(3,2,10,10);
        setLayout(grid);
        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                String Name = name.getName();
                char[] passW = pass.getPassword();
                
                try {
                    String passHash = SHA2.createHash(passW);
                    client.sendData("LOGIN "+ Name + " " + passHash);
                } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    catch (InvalidKeySpecException ex){
                        
                    }
                    catch (IOException ex){
                        
                    }
                String response = client.recieveData();
                if(response.equals("LOGIN1")){
                    try {
                        runApp();
                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.printf("Hello");
                    }
                        catch(ClassNotFoundException ex){
                            
                        }
                }
                else
                {
                    showError("Login Failed! Incorrect Username or password!");
                }
            }
        });
        newuser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                SignUp signup= new SignUp(client);
                signup.setVisible(true);
                signup.setSize(300, 200);
                signup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        add(userName);
        add(name);
        add(password);
        add(pass);
        add(login);
        add(newuser);
    }
   private void runApp() throws IOException, ClassNotFoundException{
       setVisible(false);
        CalendarFrame frame = new CalendarFrame(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(570,570);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
    public void showError(String message){
        JOptionPane.showInternalMessageDialog(null, message);
    }    
}
