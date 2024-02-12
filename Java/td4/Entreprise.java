package td4;

public class Entreprise {
    private String raisonSociale;
    private Personne comptable;
    
    public Entreprise(String rs, Personne cp){
        this.raisonSociale = rs;
        this.comptable = cp;
    }

    public String toString(){
        return "Société :"+this.raisonSociale+"\nComptable :"+this.comptable.getNom();
    }

    public void afficher(){
        System.out.println(this.toString());
    }
}
