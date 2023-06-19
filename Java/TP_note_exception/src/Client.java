
public class Client {
	
	private int num;
	private String nom;
	private String prenom;
	private char age;
	
	static private int nb = 0;

	public Client(String nom, String prenom, char age) {
		super();
		this.num = nb+1;
		nb++;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public char getAge() {
		return age;
	}

	public void setAge(char age) {
		this.age = age;
	}

	public int getNum() {
		return num;
	}
	
	public void afficher() {
		System.out.println("Numéro : "+this.num+", Nom : "+this.nom+", Prenom : "+this.prenom+", Age : "+this.age);
	}
	
		
	@Override
	public String toString() {
		return "Client [num=" + num + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		Client c1 = new Client("Durand","Toto", 'E');
		Client c2 = new Client("Dural","Tata", 'S');
		
		c1.afficher();
		c2.afficher();
	}
	

}
