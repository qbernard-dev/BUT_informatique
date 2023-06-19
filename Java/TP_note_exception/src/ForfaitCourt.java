
public class ForfaitCourt extends Forfait{
	
	private String date;
	
	static private float prix = (float) 49.50;

	public ForfaitCourt(Domaine domaine, Client client, boolean assurance, String date) {
		super(domaine, client, assurance);
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public float prixForfait() {

		if(this.getClient().getAge() == 'E') {
			prix = (float) (prix * 0.9);
		}
		if(this.getClient().getAge() == 'S') {
			prix = (float) (prix * 0.7);
		}
		if(this.isAssurance() == true) {
			prix += 15;
		}
		
		return prix;
	}
	
	
	
}
