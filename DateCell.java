
package calendar;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class DateCell extends JPanel {
    private JTextPane DateLabel;
    private boolean WoG;
    
    public DateCell(){
        super();
        super.setBackground(Color.WHITE);
        WoG = false;
        DateLabel = new JTextPane();
        makeLabelStyle();
        add(DateLabel);
        
        
    }
    public void setDateLabel(GymData gD, boolean WentToGym){
        //String Months[]={"January","Febraury","March","April","May","June","July","August","September","October","November","December"};
        //String days[] = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        DateLabel.setContentType("text/html");
        String date = "";
        //date+="<html><center><span style='color:red; font-size:40;'><b>"+gD.getDate()+"</b></span><br /><span style='font-weight:bold; font-size:20'>"+Months[gD.getMonth()]+"</span><br />"+gD.getYear()+"<br />"+days[gD.getDay()-1]+"</center></html>";
        date+="<html><center><span style='color:black; font-size:20; font-family:sogue UI;'><b>" +gD.getDate()+"</b></span></center></html>";
        DateLabel.setText(date);
        WoG = WentToGym;
        repaint();
    }
    public void removeDateLabel(){
        DateLabel.setContentType("text/html");
        String date = "";
        date+="<html><center><span style='color:black; fontsize:20'><b></b></span></center></html>";
        DateLabel.setText(date);
        WoG = false;
        repaint();
    }
    
    private void makeLabelStyle() {  
    if (this == null)  
         return;
    DateLabel.setEditable(false);  
    DateLabel.setCursor(null);  
    DateLabel.setOpaque(false);  
    DateLabel.setFocusable(false);   
  }  
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int x2 = super.getWidth();
        int y2 = super.getHeight();
        
        g.setColor(Color.red);
        if(WoG)
        {g.drawLine(0, 0, x2, y2);
        g.drawLine(x2, 0, 0, y2);
        }
    }
}
