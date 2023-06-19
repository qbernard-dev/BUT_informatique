import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Abonne {
	private String nom;
	private String addresse;
	private HashSet<NumTel> hset;
	private Scanner scanner;
	
	public Abonne(String nom, String addresse) {
		this.nom = nom;
		this.hset = new HashSet<NumTel>();
		this.addresse = addresse;
	}
	
	public Abonne() {
		System.out.print("Ecrivez un numéro: ");
		
		scanner = new Scanner(System.in);
		
        String num = scanner.next();

        System.out.println(num);
	}
	
	public void addNum() {
		System.out.print("Ecrivez un numéro a AJOUTER: ");

		scanner = new Scanner(System.in);
		
        String num = scanner.next();
        
  	     Iterator<NumTel> it = hset.iterator();
  	     while(it.hasNext()){
  	        if(it.next().getValeur().equals(num)) {
  	        	System.out.println("Numéro deja dedans");
  	        	return;
  	        }
  	     }
        
        try {
            NumTel a = new NumTel(num);
            this.hset.add(a);
        } catch(ExceptionNumero e) {
        	System.out.println("Numéro entrée invalide !");
        	addNum();
        }
	}

	@Override
	public String toString() {
		return "Abonne [nom=" + nom + ", addresse=" + addresse + ", collection=" + hset + ", scanner=" + scanner
				+ "]";
	}
	
	public void mesNums() {
		System.out.println("Numéros de l'abonner");
	     Iterator<NumTel> it = hset.iterator();
	     while(it.hasNext()){
	        System.out.println(it.next().getValeur());
	     }
	}
	
	public void tejNum() {
		System.out.print("Ecrivez un numéro a RETIRER: ");
		
		scanner = new Scanner(System.in);
		
        String num = scanner.next();
	     Iterator<NumTel> it = hset.iterator();
	     while(it.hasNext()){
	    	 NumTel val = it.next();
	    	 if(val.getValeur().equals(num)) {
					hset.remove(val);
					System.out.println("Numéro supprimer");
				}
	     }
	}
	
	public static void main(String[] args) {
		Abonne a = new Abonne("jean","Neymar");
		a.addNum();
		a.mesNums();
		a.addNum();
		a.mesNums();
	}

	public HashSet<NumTel> getHset() {
		return hset;
	}

	public void setHset(HashSet<NumTel> hset) {
		this.hset = hset;
	}
}
