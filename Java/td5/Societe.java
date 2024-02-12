package td5;

abstract class Societe {
    private String nom;
    private int benefice;
    
    public Societe(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public String toString(){
        return (this.nom+"bénéfice :"+this.benefice()+"euros\n");
    }

    public void afficher(){
        System.out.println(this);
    }

    public abstract int benefice();
}
