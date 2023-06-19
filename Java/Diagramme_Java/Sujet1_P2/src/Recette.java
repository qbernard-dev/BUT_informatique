
public class Recette {

	private String description;

	public Recette(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Recette [description=" + description + "]";
	}
	
	
}
