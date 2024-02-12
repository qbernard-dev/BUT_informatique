import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Aff_date {
    public static void main (String[] args){
        //Q1
        System.out.println(System.currentTimeMillis() / 1000 + " secondes");

        //Q2
        Calendar c = Calendar.getInstance();
        int day, month;
        String[]  mois = {"janviers", "février", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre"} ;
        String[] jour = {"dimanche", "lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi"};
        day = c.get(Calendar.DAY_OF_WEEK);
        month =  c.get(Calendar.MONTH);
        System.out.println( jour[day-1] + " " + c.get(Calendar.DAY_OF_MONTH) + " "+ mois[month] + " " + c.get(Calendar.YEAR));
        
        //Q3
        Date d = new Date();
        SimpleDateFormat f=new SimpleDateFormat("dd MMMMM yyyy HH:mm");
        System.out.println("maintenant: " + f.format(d));

        SimpleDateFormat f1=new SimpleDateFormat("dd MM yy HH:mm:ss");
        System.out.println("maintenant: " + f1.format(d));

        SimpleDateFormat f2=new SimpleDateFormat("EEEE d MMMMM yyyy HH:mm:ss");
        System.out.println("maintenant: " + f2.format(d));

    }
}
