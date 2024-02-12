package tp2;

import java.util.Scanner;

public class Produit {
    static String ligne;
    static Scanner entree=new Scanner (System.in);

    private String ref;
    private int date;

    public Produit(){
        System.out.println("Entrez la ref du produit");
        ref = entree.next();

        System.out.println("Entrez la date du produit ");
        date = entree.nextInt();
    }

    public String getref(){
        return ref;
    }

    public int getdate(){
        return date;
    }

    public void setdate(int nvdate){
        if(this.date < 0 && this.date < 32){
            this.date = nvdate;
        }
        else{
            System.out.println("ERREUR");
        }
    }

    public void afficher(){
        System.out.println("Ref : " + this.ref + " Jour : " + this.date);
    }
}
