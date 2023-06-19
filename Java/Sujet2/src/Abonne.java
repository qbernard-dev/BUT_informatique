import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Abonne {
	private String nom, adresse;
	private HashSet<NumTel> numTelephones;
	
	public Abonne(String n, String a) {
		this.nom = n;
		this.adresse = a;
		this.numTelephones = new HashSet<NumTel>();
	}
	
	public Abonne() {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Quel est votre nom ?");
			this.nom = scan.nextLine();
			
			System.out.println("Quel est votre adresse ?");
			this.adresse = scan.nextLine();
		}catch(InputMismatchException e) {
			this.nom = null;
			this.adresse = null;
			System.err.println("Les valeurs ne sont pas des caractères !");
		}
		this.numTelephones = new HashSet<NumTel>();
		scan.close();
	}
	
	public void addNum(AnnuaireReverse a) throws ExceptionNumero{
		NumTel n = null;
		String num, com;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Ajouter un numéro");
		num = scan.nextLine();
		System.out.println("Quel est le commentaire ?");
		com = scan.nextLine();
		n = new NumTel(num, com);
		if(numTelephones.contains(n)) {
			System.err.println("Erreur doublon");
		}
		else {
				this.numTelephones.add(n);
		}	
	}

	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public HashSet<NumTel> getNumTelephones() {
		return numTelephones;
	}

	public void setNumTelephones(HashSet<NumTel> numTelephones) {
		this.numTelephones = numTelephones;
	}
	
	public Iterator getIterator() {
		return numTelephones.iterator();
	}

	@Override
	public String toString() {
		return "Abonne [nom=" + nom + ", adresse=" + adresse + "";
	}
	
	
	public void affichageNum() {
		Iterator<NumTel> iterateur = numTelephones.iterator();
		NumTel element;
		while(iterateur.hasNext()) {
			element = iterateur.next();
			System.out.println(element);
		}
	}
	
	public void supprimerNum(AnnuaireReverse a)  {
		NumTel numSup;
		String num,com;
		Scanner scan = new Scanner(System.in);
		System.out.println("Quel est le numéro que vous voulez supprimer ?");
		num = scan.nextLine();
		numSup = new NumTel(num, null);
		
		if (numTelephones.contains(numSup)) {
				numTelephones .remove( numSup );
				a.desinscrire(this);
		}
		
		else {
			System.out.println("pas possible");
		}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abonne other = (Abonne) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(nom, other.nom)
				&& Objects.equals(numTelephones, other.numTelephones);
	}

	public static void main(String args[]) throws ExceptionNumero {
		Abonne a = new Abonne("Michel","15 rue du per");
		Abonne a2 = new Abonne("Leo","27 rue du merland");
		AnnuaireReverse annuaire = new AnnuaireReverse(a.nom);
		try {
			a.addNum(annuaire);
		} catch (ExceptionNumero e) {
			e.printStackTrace();
		}
		
		System.out.println("/*2 ème abo : */");
		try {
			a2.addNum(annuaire);
		} catch (ExceptionNumero e) {
			e.printStackTrace();
		}
		
		System.out.println("/*Suppression 1er abo :*/");
		
		try {
			a.supprimerNum(annuaire);
		} catch (ExceptionNumero e) {
			e.printStackTrace();
		}
		
		System.out.println("/*Suppression 2eme abo :*/");
		
		try {
			a2.supprimerNum(annuaire);
		} catch (ExceptionNumero e) {
			e.printStackTrace();
		}
		a.affichageNum();
		a2.affichageNum();
	}
	}
		