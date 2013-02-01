
package calendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CalendarFrame extends JFrame {
    private GymData gymdata;
    private GymData today;
    private Client client;
    public CalendarFrame(Client cl){
        super("Gym Calendar");
        initComponents();
        client = cl;
        setLocationRelativeTo(null);
        String s;
        gymdata = new GymData();
        today = new GymData();
        try {
            client.sendData("CURSTR");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in connection!","Error" ,JOptionPane.ERROR_MESSAGE);
        }
        s = client.recieveData();
        currentStreakLabel.setText("Current Streak is "+s);
        try {
            client.sendData("MAXSTR");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in connection!","Error" ,JOptionPane.ERROR_MESSAGE);
        }
        s = client.recieveData();
        MaximumStreakLabel.setText("Maximum Streak is "+s);

        String date = today.getDate()+"/"+today.getMonth()+"/"+today.getYear();
        try {
            client.sendData(date);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in connection!","Error" ,JOptionPane.ERROR_MESSAGE);
        }
        s = client.recieveData();
        if(s.equals("1")){
            todayPanel.setVisible(false);
        }
        yesButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try {
                    client.sendData("MARK");
                    todayPanel.setVisible(false);
                    gymdata.setMonth(-1);
                    showTheMonth();
                } catch (IOException ex) {
                  JOptionPane.showMessageDialog(null, "Error in connection!","Error" ,JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        noButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                todayPanel.setVisible(false);
            }
        });
    
          showTheMonth();
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        prev = new javax.swing.JButton();
        next = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        month = new javax.swing.JLabel();
        mon = new javax.swing.JLabel();
        sun = new javax.swing.JLabel();
        fri = new javax.swing.JLabel();
        thurs = new javax.swing.JLabel();
        tue = new javax.swing.JLabel();
        wed = new javax.swing.JLabel();
        sat = new javax.swing.JLabel();
        currentStreakLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        date1 = new calendar.DateGrid();
        jSeparator1 = new javax.swing.JSeparator();
        todayPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        yesButton = new javax.swing.JButton();
        noButton = new javax.swing.JButton();
        MaximumStreakLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        prev.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        prev.setText("Previous");
        prev.setToolTipText("Click to view previous month");
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        next.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        next.setText("Next");
        next.setToolTipText("Click to view next month");
        next.setPreferredSize(new java.awt.Dimension(73, 23));
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        welcomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome");

        month.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        month.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        month.setText("January, 2012");

        mon.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        mon.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        mon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mon.setText("Mon");
        mon.setToolTipText("Monday");

        sun.setBackground(new java.awt.Color(255, 255, 255));
        sun.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        sun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sun.setText("Sun");

        fri.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        fri.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fri.setText("Fri");

        thurs.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        thurs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thurs.setText("Thurs");

        tue.setBackground(new java.awt.Color(255, 255, 255));
        tue.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        tue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tue.setText("Tue");

        wed.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        wed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wed.setText("Wed");

        sat.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        sat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sat.setText("Sat");

        currentStreakLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        date1.setBackground(new java.awt.Color(102, 102, 102));

        todayPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Are you going to the gym today?");

        yesButton.setText("Yes");

        noButton.setText("No");

        javax.swing.GroupLayout todayPanelLayout = new javax.swing.GroupLayout(todayPanel);
        todayPanel.setLayout(todayPanelLayout);
        todayPanelLayout.setHorizontalGroup(
            todayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(todayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(todayPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(77, Short.MAX_VALUE))
                    .addGroup(todayPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(yesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(noButton)
                        .addGap(21, 21, 21))))
        );
        todayPanelLayout.setVerticalGroup(
            todayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todayPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(todayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(yesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        MaximumStreakLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prev)
                    .addComponent(mon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tue, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(wed, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thurs, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sat, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sun, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(month, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jSeparator2)
            .addComponent(date1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentStreakLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MaximumStreakLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(todayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(prev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mon, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thurs, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tue, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wed, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sun, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fri, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(todayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MaximumStreakLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(currentStreakLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
        gymdata.setMonth(-2);
               showTheMonth();
        
    }//GEN-LAST:event_prevActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed

        
        showTheMonth();
        
    }//GEN-LAST:event_nextActionPerformed
    private void showTheMonth(){
    String Months[]={"January","Febraury","March","April","May","June","July","August","September","October","November","December"};
     boolean went;
     gymdata.setDate(1);
      int i=gymdata.getDay()-2;
      if(i==-1){
          i=6;
      }
      String mnth = Months[gymdata.getMonth()] + ", " + gymdata.getYear();
      month.setText(mnth);
     int days = gymdata.getLastDate();
     for(int j=0;j<35;j++){
         date1.removeDateLabel(j);
     }
        for(int j=0;j<days;j++){
            try {
                went = false;
                client.sendData("DAY "+gymdata.getDate()+"/"+gymdata.getMonth()+"/"+gymdata.getYear());
                if(client.recieveData().compareTo("1") == 0) {
                    date1.setDateLabel(i%35,gymdata,true);
                }
                date1.setDateLabel(i%35,gymdata,false);
                gymdata.addDate(1);
                i++;
             } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error in connection!","Error" ,JOptionPane.ERROR_MESSAGE);
            }
        }
        
    
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MaximumStreakLabel;
    private javax.swing.JLabel currentStreakLabel;
    private calendar.DateGrid date1;
    private javax.swing.JLabel fri;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel mon;
    private javax.swing.JLabel month;
    private javax.swing.JButton next;
    private javax.swing.JButton noButton;
    private javax.swing.JButton prev;
    private javax.swing.JLabel sat;
    private javax.swing.JLabel sun;
    private javax.swing.JLabel thurs;
    private javax.swing.JPanel todayPanel;
    private javax.swing.JLabel tue;
    private javax.swing.JLabel wed;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JButton yesButton;
    // End of variables declaration//GEN-END:variables
}


