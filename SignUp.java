
package calendar;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class SignUp extends JFrame{
      private JLabel userName;
      private JLabel password;
      private JLabel confirmPassword;
      private JTextField name;
      private JPasswordField pass;
      private JPasswordField confirmPass;
      private JButton createAcc;
      private Client client;
      private boolean regd = false;
      
    public SignUp(Client cl){
        super("New User SignUp");
        setLocationRelativeTo(null);
        client = cl;
        userName = new JLabel("Username: ");
        password = new JLabel("Password: ");
        confirmPassword = new JLabel("Confirm Password: ");
        name = new JTextField("");
        pass = new JPasswordField("");
        confirmPass = new JPasswordField("");
        createAcc = new JButton("Create Account");
        createAcc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                String Name = name.getName();
                char[] passW = pass.getPassword();
                char[] cPassW = confirmPass.getPassword();
                System.out.printf("%s %s",passW,cPassW);
                if(Arrays.equals(passW, cPassW)){
                try {
                      String passHash = SHA2.createHash(passW);
                    client.sendData("REG "+Name+" "+passHash);
                }   catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    catch (InvalidKeySpecException ex){
                        
                    }
                    catch (IOException ex){
                        
                    }
                if(client.recieveData().compareTo("REG1")==0){
                    JOptionPane.showMessageDialog(null, "Succesfully registered!");
                    regd = true;
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Unable to register! Error at server. Please try again later");
                }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Passwords don't match! Reenter");
                    pass.setText("");
                    confirmPass.setText("");
                }
            }
        });
        GridLayout grid = new GridLayout(4,2,10,10);
        setLayout(grid);
        add(userName);
        add(name);
        add(password);
        add(pass);
        add(confirmPassword);
        add(confirmPass);
        add(createAcc);
      }
    public boolean registered(){
        return regd;
    }
}
