import java.io.*;
import java.util.Scanner;

public class Tp1bis {
    public static void main (String[] args){
        //Q1
        int val, res2;
        String res, ligne;
         /*
        val = 12345;
        res = String.valueOf(val);
        System.out.println(res);
        */ 

        //Q2
        /*
        Scanner entree = new Scanner(System.in);
        System.out.println("Ecrivez votre chaine : ");
        ligne = entree.next();
        res2 = Integer.parseInt(ligne);
        entree.close();
        System.out.println(res2);
        */ 

        /*Q3
        float res3;
        Scanner entree = new Scanner(System.in);
        System.out.println("Ecrivez votre chaine : ");
        ligne = entree.next();
        res3 = Float.parseFloat(ligne);
        res3 += (flaot)1.1;
        System.out.println(res3);
        entree.close();
        */

        //Q4
        /*
        Scanner entree = new Scanner(System.in);
        System.out.println("Ecrivez votre chaine : ");
        ligne = entree.next();
        ligne = ligne.trim();
        ligne = ligne.toUpperCase();
        entree.close();
        System.out.println(ligne);
        */

        //Q5
        /*
        String ligne2;
        Scanner entree = new Scanner(System.in);
        System.out.println("Ecrivez votre chaine : ");
        ligne = entree.next();
        entree.close();

        Scanner entree1 = new Scanner(System.in);
        System.out.println("Ecrivez votre chaine : ");
        ligne2 = entree.next();
        entree1.close();
        
        if(ligne.charAt(0) == ligne2.charAt(0)){
            System.out.println("GOOD");
        }
        else{
            System.out.println("NO GOOD");
        }
        */

        //Q6
        /*
        String s1, s2;
        Scanner entree = new Scanner(System.in);
        System.out.println("Ecrivez votre chaine : ");
        s1 = entree.next();

        Scanner entree1 = new Scanner(System.in);
        System.out.println("Ecrivez votre chaine : ");
        s2 = entree.next();

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareToIgnoreCase(s2));
        */

        //Q7
        /*
        String s1, s2;
        Scanner entree = new Scanner(System.in);
        System.out.println("Ecrivez votre chaine : ");
        s1 = entree.next();

        Scanner entree1 = new Scanner(System.in);
        System.out.println("Ecrivez votre chaine : ");
        s2 = entree.next();

        System.out.println(s1.startsWith(s2));
        System.out.println(s1.endsWith(s2));
        System.out.println(s1.contains(s2));
        */

        //Q8
        String s1, s2;
        int val1;
        Scanner entree = new Scanner(System.in);
        System.out.println("Ecrivez votre chaine : ");
        s1 = entree.next();

        Scanner entree1 = new Scanner(System.in);
        System.out.println("Ecrivez votre chaine : ");
        s2 = entree.next();
        
        
        if (s1.contains(s2)){
            int index;
            index = s1.indexOf(s2);
            System.out.println(s1.substring(0, index) + s1.substring(index + ));
        }
        else {
            System.out.println(s1);
        }
    }
    
}
