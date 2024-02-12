package tp2;

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

    /*
        PLUS SIMPLE !!!
    
        System.out.println("Entrez un entier");
        ligne = entree.nextInt();

        System.out.println("Entrez un réel");
        ligne = entree.nextFloat();

        System.out.println("Entrez un double");
        ligne = entree.nextDouble();

    */  
}