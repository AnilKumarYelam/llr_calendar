
package calendar;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class DateGrid extends JPanel{
    private DateCell dates[];
    public DateGrid(){
        setBackground(Color.DARK_GRAY);
        dates = new DateCell[35];
        GridLayout grid = new GridLayout(5,7,5,5);
        setLayout(grid);
        for(int i=0;i<35;i++){
            dates[i] = new DateCell();
            add(dates[i]);
        }
    }
    public void setDateLabel(int i, GymData gym, boolean b){
        dates[i].setDateLabel(gym,b);
    }
    public void removeDateLabel(int i){
        dates[i].removeDateLabel();
    }
}
