
abstract class Forfait {
	
	private Domaine domaine;
	private Client client;
	private boolean assurance;
	
	public Forfait(Domaine domaine, Client client, boolean assurance) {
		super();
		this.domaine = domaine;
		this.client = client;
		this.assurance = assurance;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public boolean isAssurance() {
		return assurance;
	}

	public void setAssurance(boolean assurance) {
		this.assurance = assurance;
	}
	
	abstract public float prixForfait();
	
	public void afficher() {
		System.out.println("Domaine  :"+"\n"+this.domaine+"\n"+ "Client : "+"\n"+this.client+"\n"+"assurance : "+this.assurance+", prix : "+this.prixForfait());
	}

	@Override
	public String toString() {
		return "Forfait [domaine=" + domaine + ", client=" + client + ", assurance=" + assurance + "]";
	}
	
	
	
	
	

}
