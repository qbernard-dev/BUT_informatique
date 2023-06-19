
public class ForfaitLong extends Forfait{
	
	private String date_debut;
	private int duree;
	private float reduc;
	
	static private float prix = (float) 42.50;
	
	public ForfaitLong(Domaine domaine, Client client, boolean assurance, String date_debut, int duree) {
		super(domaine, client, assurance);
		this.date_debut = date_debut;
		this.duree = duree;
		this.reduc = (float) 0.90;
	}

	public String getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public float getReduc() {
		return reduc;
	}

	public void setReduc(float reduc) {
		this.reduc = reduc;
	}

	@Override
	public float prixForfait() {
		
		prix = prix * this.duree;
		prix = prix * this.reduc;
		
		if(this.isAssurance() == true) {
			prix += 15;
		}
		
		return prix;
	}
	
	
	
	
}
