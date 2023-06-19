
public class Enregistrement {
	
	private int identifiant;
	private String adresse;
	private String dateDeDeclaration;
	
	public Enregistrement(int identifiant, String adresse, String dateDeDeclaration) {
		this.identifiant = identifiant;
		this.adresse = adresse;
		this.dateDeDeclaration = dateDeDeclaration;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getDateDeDeclaration() {
		return dateDeDeclaration;
	}
		
	public String toString() {
		return "Enregistrement [identifiant=" + identifiant + ", adresse=" + adresse + ", dateDeDeclaration="
				+ dateDeDeclaration + "]";
	}

	
	

}
