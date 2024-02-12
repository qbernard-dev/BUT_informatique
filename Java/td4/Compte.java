package td4;

public class Compte {
    private String numero;
    private Personne titulaire;
    private double solde;

    public double getSolde(){
        return this.solde;
    }

    public void setSolde(double montant){
        this.solde = montant;
    }

    public Compte(String numero, Personne titulaire){
        this.numero = numero; 
        this.titulaire = titulaire;
        this.solde = 0;
    }

    public String toString(){
        return "Compte n"+this.numero+"\nTitulaire : "+this.titulaire.toString()+"\nSolde de :"+this.solde+"€";
    }

    public void afficher(){
        System.out.println(this.toString());
    }

    public void deposer(double somme){
        this.solde = this.solde+somme;
        System.out.println("Ajout de ;"+somme+"€");
    }

    public void retirer(double somme){
        if(this.solde - somme >= 0){
            this.solde = this.solde - somme;
            System.out.println("Retrait de :"+somme+"€");
        }
        else {
            System.out.println("Retrait impossible, somme trop importante");
        }

    }
}
