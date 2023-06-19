
public class MonException extends Exception{

	private int nb_note;
	
	
	public MonException(int nb_note) {
		super();
		this.nb_note = nb_note;
	}

	@Override
	public String toString() {
		return "Le nombre de note est de "+this.nb_note;
	}
	
}
