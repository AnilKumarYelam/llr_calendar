
package calendar;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GymData implements Serializable {
private int dd;
private int mm;
private int yy;
Calendar cal;

public GymData(){
    cal = new GregorianCalendar();
    dd = cal.get(GregorianCalendar.DATE);
    mm = cal.get(GregorianCalendar.MONTH);
    yy = cal.get(GregorianCalendar.YEAR);
}
public int getMonth(){
    return mm;
}
public int getDate(){
    return dd;
}
public int getYear(){
    return yy;
}
public void setMonth(int n){
    cal.add(GregorianCalendar.MONTH, n);
    dd = cal.get(GregorianCalendar.DATE);
    mm = cal.get(GregorianCalendar.MONTH);
    yy = cal.get(GregorianCalendar.YEAR);
}
public void setDate(int n){
    cal.set(GregorianCalendar.DATE, n);
    dd = cal.get(GregorianCalendar.DATE);
    mm = cal.get(GregorianCalendar.MONTH);
    yy = cal.get(GregorianCalendar.YEAR);
}
public void addDate(int n){
    cal.add(GregorianCalendar.DATE, n);
    dd = cal.get(GregorianCalendar.DATE);
    mm = cal.get(GregorianCalendar.MONTH);
    yy = cal.get(GregorianCalendar.YEAR);
}
public int getDay(){
    return cal.get(GregorianCalendar.DAY_OF_WEEK);
}
public int getLastDate(){
    return cal.getActualMaximum(GregorianCalendar.DATE);
}
public boolean compareDate(GymData gD){
    return dd==gD.getDate() && mm == gD.getMonth() && yy == gD.getYear();
            }

}
