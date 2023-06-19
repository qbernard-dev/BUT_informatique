
public class Location {

	private int num;
	private Voiture voiture;
	private Client client;
	private Date loc;
	private Date retour;
	private int km;
	
	static private 
	int nb = 1;
	
	public Location(Voiture voiture, Client client, Date loc) {
		super();
		this.num = Location.nb;
		Location.nb++;
		this.voiture = voiture;
		this.client = client;
		this.loc = loc;
		this.retour = null;
		this.km = voiture.getKm();
	}
	
	public Date getRetour() {
		return retour;
	}

	public void setRetour(Date retour) {
		this.retour = retour;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getNum() {
		return num;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public Client getClient() {
		return client;
	}

	public Date getLoc() {
		return loc;
	}
	
	public void afficher() {
		if (retour == null) {
			System.out.println("Loation en cours");
		}
		else {
			System.out.println("Num : "+this.num+"\nVoiture : "+this.voiture+"\nClient : "+this.client+"\nDate de Loc : "+this.loc+"\nDate de retour : "+this.retour+"\nKm : "+this.km);
		}
	}

	public static void main(String[] args) {
		/*
		Voiture v1 = new Voiture();
		Client c1 = new Client();
		Date d1 = new Date();
		Location l1 = new Location(v1, c1, d1);
		
		l1.afficher();
		l1.setRetour(new Date());
		l1.afficher();
		*/
	}

}
