import java.util.ArrayList;

public class Commercial {

	private String identif;
	private String specialiste;
	private ArrayList<Zone_geo> array;
	
	public Commercial(String identif, String specialiste, ArrayList<Zone_geo> array) {
		super();
		this.identif = identif;
		this.specialiste = specialiste;
		this.array = new ArrayList<Zone_geo>(10);
	}

	public String getIdentif() {
		return identif;
	}

	public String getSpecialiste() {
		return specialiste;
	}
		
	@Override
	public String toString() {
		return "Commercial [identif=" + identif + ", specialiste=" + specialiste + ", array=" + array + "]";
	}

	public void ajouter(Zone_geo z) {
		if (!array.contains(z)) {
			array.add(z);
		} 
		else {
			System.out.println("deja dedans");
		}
		
	}
	
	public void supprimer(Zone_geo z) {
		array.remove(z);
	}
}
