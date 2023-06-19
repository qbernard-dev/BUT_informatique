
public class Sport {
	
	private int code;
	private String libelle;
	
	public Sport(int code, String libelle) {
		super();
		this.code = code;
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getCode() {
		return code;
	}
	
	public void afficher() {
		System.out.println("Code : "+this.code+"\nLibelle : "+this.libelle);
	}
	
	public String toString() {
		return "Code : "+this.code+"\nLibelle : "+this.libelle;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
