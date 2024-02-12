import java.io.*;
import java.util.Scanner;

/* Jeu du Domino Partie 2 la Table*/

public class Domino {
    private Domino[] tabdom;
    private int ndp;

    public void initTable(){
        int g,d;

        Scanner scan = new Scanner(System.in);

        System.out.println("entrez la valeur gauche : ");
        g = scan.nextInt();

        System.out.println("entrez la valeur droite : ");
        d = scan.nextInt();

        Domino dom = new Domino (1,2);

        this.tabdom[i] = dom;
        i++;
        this.npd = i; 
    }

    public void affTable(){
        System.out.println("table de "+ndp+"dominos");
        for (int i=0; i < this.ndp; i++){
            this.tabdom[i].afficher();
        }
    }

    public int recherche(int g, int d){
        if((this.tabdom[0].lagauche() == g) || (this.tabdom[0].lagauche() == d)){
            return -1;
        }
        else if((this.tabdom[ndp-1].ladroite() == d ||(this.tabdom[ndp-1].ladroite() == g ){
            return 1;
        }
        else {
            return 0;
        }
    }
}
