import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
 
public class AnnuaireReverse {
	
    private String nom;
    private HashMap<String,Abonne> anuaire;
 
    public void Annuaire_inverse(String nom) {
        this.nom = nom;
        this.anuaire=new HashMap<String,Abonne>();
    }
    public void inscrire(Abonne abo) {
        Iterator<NumTel> nums=abo.getIterator();
        NumTel courant;
        while(nums.hasNext()) {
            courant=nums.next();
            this.anuaire.put(courant.getValeur(), abo);
        }
    }
    public Abonne qui(String numero) {
        return anuaire.get(numero);
    }
    public void desinscrire(Abonne abo) {
        Iterator<NumTel> nums=abo.getIterator();
        NumTel courant;
        while(nums.hasNext()) {
            courant=nums.next();
            this.anuaire.remove(courant.getValeur());
        }
    }
    @Override
    public String toString() {
        String res="";
        res=this.nom+": \n";
        Iterator<String> it=anuaire.keySet().iterator();
        String courant;
        while(it.hasNext()) {
            courant=it.next();
            res=res+courant+":"+anuaire.get(courant).getNom()+"\n";
        }
        return res;
    }
//    public boolean equals(Object e) {
//        boolean bon=false;
//        if(this.nom=Annuaire_inverse) e).getNom()) {
//            bon=true;
//        }
//        return bon;
//    }
//     
    
    public static void main(String[] args) {
        Abonne a=new Abonne("Jack","Rue de la soif");
        a.addNum();
        a.addNum();
        Abonne b=new Abonne("Jick","Rue de la soif");
        b.addNum();
        AnnuaireReverse an=new AnnuaireReverse("Orange annuaire");
        an.inscrire(a);
        System.out.println(an);
        an.inscrire(b);
        System.out.println(an);
        an.desinscrire(a);
        System.out.println(an);
    }
    public String getNom() {
        return nom;
    }
}