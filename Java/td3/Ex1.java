package td3;
import java.net.PortUnreachableException;
import java.util.ArrayList;

import javax.naming.InterruptedNamingException;

public class Ex1 {
    private ArrayList<Integer> elements ;

    public Ensemble() {
        this.elements = new ArrayList<Integer>(100);
    }

    public void ajoute (Integer a){
        if (!elements.contains(a)) elements.add(a);
    }

    public Integer longueur() {
        return elements.size();
    }

    public Integer getElement(int i) {
        if (i < this.elements.size()){
            return elements.get(i);
        }
        else {
            return null ;
        }
    }

    public String toString() {
        String resultat = new String("");
        int i, taille ;
        Integer val;
        taille = elements.size() ;
        i = 0;
        while (i < taille){
            val = elements.get(i);
            resultat = resultat+""+val.toString();
            i++ ;
        }
        if (i == 0){
            return "ensemble vide";
        }
        else {
            return resultat;
        }
    }

    public Ensemble union (Ensemble b){
        Ensemble resultat = new Ensemble();

        for (int i = 0; i < this.taille(); i++ ){
            resultat.ajoute(this.getElement(i));
        }

        for (int i = 0; i < b.taille(); i++){
            if (this.elements.contains(b.getElement(i))){
                resultat.ajoute(b.getElement(i));
            }
        }

        return resultat;
    }

    public Ensemble intersection (Ensemble b) {
        Ensemble resultat = new Ensemble();

        for (int = 0; i < b.taille(); i++){
            if (this.elements.contains(b.getElement(i))){
                resultat.ajoute(b.getElement(i));
            }
        }


    }
}
