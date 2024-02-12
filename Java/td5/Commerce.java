package td5;

public class Commerce extends Societe {
    private int ventes;
    private int salaires;
    private int materiel;

    public Commerce(String nom, int ventes, int salaires, int materiel){
        super(nom);
        this.ventes = ventes;
        this.salaires = salaires;
        this.materiel = materiel;
    }

    public int benefice(){
        return this.ventes - this.salaires - this.materiel;
    }

    public String toString(){
        return (super.toString()+"ventes :"+this.ventes+"euros\nmasse salarial :"+this.salaires+"euros\nmatériel :"+this.materiel+"euros");
    }
}
