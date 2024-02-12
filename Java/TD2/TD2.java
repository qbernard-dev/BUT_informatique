import java.io.*;
import java.util.Scanner;

/* Jeu du Domino */

public class TD2 {
    private int gauche;
    private int droite;

    public TD2 (int g, int d){
        this.gauche = g;
        this.droite = d;
    }

    public void afficher(){
        System.out.println(this.gauche + "|" + this.droite);
    }

    public void inverser(){
        int inter;

        inter = this.gauche;
        this.gauche = this.droite;
        this.droite = inter;

        System.out.println(this.gauche + "|" + this.droite);
    }

    public int lagauche(){
        return this.gauche;
    }

    public int ladroite(){
        return this.droite;
    }  


    public static void main(String[] args) {
        TD2 quentin = new TD2(5, 2);

        quentin.afficher();
        quentin.inverser();
    }
}
