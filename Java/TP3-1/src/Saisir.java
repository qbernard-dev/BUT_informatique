
import java.util.Scanner;

public class Saisir {
    static String ligne;
    static Scanner entree=new Scanner (System.in);

    static public int entier() {
        int x;
        System.out.println("Entrez un entier");
        ligne = entree.next();
        x = Integer.parseInt(ligne);
        return x;
    }

    static public float reelf() {
        float y;
        System.out.println("Entrez un réel");
        ligne = entree.next();
        y = Float.parseFloat(ligne);
        return y;
    }

    static public double doublef() {
        double d;
        System.out.println("Entrez un double");
        ligne = entree.next();
        d = Double.parseDouble(ligne);
        return d;
    }
    
    static public String chaine() {
        System.out.println("Entrez une chaine");
        ligne = entree.next();      
        return ligne;
    }
    
    static public char car() {
        System.out.println("Entrez un caractère");
        ligne = entree.next();
        return ligne.charAt(0);
    }

}
