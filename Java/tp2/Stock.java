package tp2;

import java.util.Scanner;

import javax.swing.SwingConstants;

public class Stock {
    private Pile pile_stock;

    public Pile getpile_stock(){
        return this.pile_stock;
    }

    public Stock(int taille){
        this.pile_stock = new Pile(taille);
    }

    public void entrer(Produit p){
        pile_stock.empiler(p);
    }

    public void sortir(int dateJ){
        Produit p;
        p = pile_stock.sommet();
        if(p.getdate() + 5 > dateJ){
            pile_stock.depiler();
        }
        else{
            System.out.println("Tous les produits sont périmés");
            for (int i=0; i < pile_stock.length; i++){
                pile_stock.depiler();
            }
        }
    }

    static private void afficheMenu(){
        System.out.println("e : entrée d’un produit dans le stock \ns : sortie d’un produit du stock \ni : incrémenter la date du jour \nq : quitter");
    }

    public static void main (String[] args){
        Stock s = new Stock(10);

        Scanner entree=new Scanner (System.in);
        int date = 1;
        String c;

        Stock.afficheMenu();
        c = entree.next();
        while (c != "q"){
            switch(c){
                case "e" :
                    Produit p = new Produit();
                    s.entrer(p);
                    break;
                
                case "s" :
                    s.sortir(date);
                    break;

                case "i" :
                    date++;
                    break;

                case "q" :
                    System.out.println("Salut mec");
                    break;

                default : 
                    System.out.println("Apprend à taper sur un clavier");
                    break;
            }
        }
    }
}
