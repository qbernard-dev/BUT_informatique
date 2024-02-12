package td4;

public class CompteEntreprise extends Compte{
    private Entreprise proprietaire;
    
    public CompteEntreprise(int num, Entreprise ent){
        super(num, ent.getComptable());
        this.proprietaire = ent;
    }

    public String toString(){
        return super.toString()+"Propriétaire :"+this.proprietaire.toString();
    } 

    
}
