import java.util.ArrayList;

public class Agence {
	
	private String nom;
	private ArrayList<Voiture> parcs = new ArrayList<Voiture>(100); 
	private ArrayList<Client> clientele = new ArrayList<Client>(100);
	private ArrayList<Location> contrats = new ArrayList<Location>(100);
	
	
	
	public Agence() {
		super();
		this.nom = Saisir.chaine();
		Voiture v1 = new Voiture("de455de", "bmw", 450, 3.3f);
		Voiture v2 = new Voiture("dz666dz", "renault", 300, 2.5f);
		parcs.add(v1);
		parcs.add(v2);

		Client c1 = new Client("Bern", "Angers");
		Client c2 = new Client("Nzo", "Quintin");
		clientele.add(c1);
		clientele.add(c2);
		
		Location l1 = new Location(v1, c1, new Date(12, 03, 2023));
		Location l2 = new Location(v2, c2, new Date(12, 03, 2023));
		contrats.add(l1);
		contrats.add(l2);
	}
	
	public void afficher_V() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Immatriculation : "+parcs.get(i).getImmat()+"\nModèle : "+parcs.get(i).getModele()+"\nKm : "+parcs.get(i).getKm()+"\nTarif : "+parcs.get(i).getTarif());
		}
	}
	
	public void afficher_C() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Num client : "+clientele.get(i).getNum()+"\nNom : "+clientele.get(i).getNom()+"\nAdresse : "+clientele.get(i).getAdresse());
		}
	}

	public void afficher_L() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Num : "+contrats.get(i).getNum()+"\nVoiture : "+contrats.get(i).getVoiture()+"\nClient : "+contrats.get(i).getClient()+"\nDate de Loc : "+contrats.get(i).getLoc()+"\nDate de retour : "+contrats.get(i).getRetour()+"\nKm : "+contrats.get(i).getKm());
		}
	}
	
	public int client_existe(int cli) {
		boolean existe = false;
		int i = 0;
		int indice = -1;
		while(existe == false && i < clientele.size()) {
			if(cli == clientele.get(i).getNum()) {
				indice = i;
				existe = true;
			}
			else {
				i++;
			}
		}
		
		return indice;
	}
	
	public void aff_voiture_dispo() {
		for (int i = 0; i < parcs.size(); i++) {
			if(contrats.get(i).getRetour() != null) {
				System.out.println(contrats.get(i).getVoiture());
			}
		}
	}
	
	public boolean voiture_existe(String immat) {
		boolean existe = false;
		int i = 0;
		while(existe == false && i < parcs.size()) {
			if(immat == parcs.get(i).getImmat()) {
				return existe = true;
			}
			else {
				i++;
			}
		}
		return existe;
	}
	
	public int voiture_dispo(String immat) {
		boolean existe = false;
		int i = 0;
		int indice = -1;
		while(existe == false && i < parcs.size()) {
			if(immat == parcs.get(i).getImmat() && contrats.get(i).getRetour() != null) {
				indice = i;
				existe = true;
			}
			else {
				i++;
			}
		}
		
		return indice;
	}
	
	public int recherche_contrat(String immat) {
		boolean existe = false;
		int i = 0;
		int indice = -1;
		while(existe == false && i < parcs.size()) {
			if(immat == contrats.get(i).getVoiture().getImmat() && contrats.get(i).getRetour() != null) {
				indice = i;
				existe = true;
			}
			else {
				i++;
			}
		}
		
		return indice;
	}
	
	public void enregistrement() {
		int cli, jour, mois, annee, i_cli, i_voiture;
		String immat;
		
		cli = Saisir.entier();
		i_cli = client_existe(cli);
		while(i_cli == -1) {
			System.out.println("Num de client introuvable");
			cli = Saisir.entier();
			i_cli = client_existe(cli);
		}
		aff_voiture_dispo();
		immat = Saisir.chaine();
		i_voiture = voiture_dispo(immat);
		while(voiture_existe(immat) == false || i_voiture == -1) {
			System.out.println("Erreur");
			aff_voiture_dispo();
			immat = Saisir.chaine();
			i_voiture = voiture_dispo(immat);
		}
		jour = Saisir.entier();
		mois = Saisir.entier();
		annee = Saisir.entier();
		Date date = new Date(jour, mois, annee);
		Location l3 = new Location(parcs.get(i_voiture), clientele.get(i_cli),  date);
		contrats.add(l3);
	}
	
	
	public void enregistre_retour() {
		String immat;
		int i_voiture, jour, mois, annee, km_r, km_d, distance, i_contrat, km_voiture;
		float prix;
		
		immat = Saisir.chaine();
		i_voiture = voiture_dispo(immat);
		while(voiture_existe(immat) == false || i_voiture == -1) {
			System.out.println("Erreur");
			immat = Saisir.chaine();
			i_voiture = voiture_dispo(immat);
		}
		System.out.println(parcs.get(i_voiture));
		jour = Saisir.entier();
		mois = Saisir.entier();
		annee = Saisir.entier();
		Date date = new Date(jour, mois, annee);
		km_r = Saisir.entier();
		while(km_r <= parcs.get(i_voiture).getKm()) {
			System.out.println("Erreur");
			km_r = Saisir.entier();
		}
		km_d = parcs.get(i_voiture).getKm();
		distance = km_r - km_d;
		prix = distance * parcs.get(i_voiture).getTarif();
		i_contrat = recherche_contrat(immat);
		contrats.get(i_contrat).setRetour(date);
		contrats.get(i_contrat).setKm(distance);
		km_voiture = parcs.get(i_voiture).getKm();
		km_voiture += distance;
		parcs.get(i_voiture).setKm(km_voiture);
		
	}
	
	public static void main(String[] args) {
		Agence a1 = new Agence();
		
		a1.afficher_V();
		a1.afficher_C();
		a1.afficher_L();
	}

}
