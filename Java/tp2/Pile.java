package tp2;

public class Pile {
    private Produit[] data;
    private int i;

    public Pile(int max){
        this.data = new Produit[max];
        this.i = -1;
    }

    public Produit[] getdata(){
        return data;
    }

    public void setdata(Produit[] nvdata){
        this.data = nvdata;
    }

    public int geti(){
        return i;
    }

    public boolean pileVide(){
        if (this.i == -1){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean pilePleine(){
        int longueur;
        longueur = this.getdata().length;

        if(this.i == longueur){
            return true;
        }
        else{
            return false;
        }
    }

    public void empiler(Produit p){
        this.data[this.geti()+1] = p;
        this.i++;
    }

    public void depiler(){
        this.data[this.geti()] = null;
        this.i--;
    }

    public Produit sommet(){
        return this.data[this.i];
    }
}
