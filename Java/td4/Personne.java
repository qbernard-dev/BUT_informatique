package td4;

public class Personne {
    private String nom, prenom, adresse;

    public double getNom(){
        return this.nom;
    }

    
    public Personne(String nom, String prenom, String adresse){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public String toString(){
        return this.nom+""+this.prenom+"habitant"+this.adresse ;
    }

    public void afficher(){
        System.out.println(this.toString());
    }

    
}
