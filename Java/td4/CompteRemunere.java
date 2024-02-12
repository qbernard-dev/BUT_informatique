package td4;

public class CompteRemunere extends Compte{
    private double taux;
    
    public CompteRemunere(String n, Personne p, double t){
        super(n,p);
        this.taux = t;
    }

    public String toString(){
        return super.toString()+" au taux :"+this.taux+"%";
    }

    public void versementinteret(){
        this.setSolde(this.getSolde()+(this.taux/100*this.getSolde()));
    }
}
