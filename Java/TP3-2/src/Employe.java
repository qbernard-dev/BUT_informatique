
abstract class Employe {
	
	private String nom;
	private int age;
	protected int nb_a;
	private int num;
	
	static private int nb = 0;
	
	public Employe(String nom, int age, int nb_a) {
		super();
		this.nom = nom;
		this.age = age;
		this.nb_a = nb_a;
		this.num = nb+1;
		nb++;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNb_a() {
		return nb_a;
	}

	public void setNb_a(int nb_a) {
		this.nb_a = nb_a;
	}

	public String getNom() {
		return nom;
	}
	
	public int getNum() {
		return num;
	}
	
	abstract public float salaire();
	abstract public String afficher();
}
