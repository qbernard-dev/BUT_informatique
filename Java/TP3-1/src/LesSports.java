import java.util.ArrayList;

public class LesSports {
	
	private ArrayList<Sport> sports = new ArrayList<Sport>(100); 
	
	
	public LesSports() {
		super();
		//this.sports = new ArrayList<Sport>();
	}

	public ArrayList<Sport> getSports() {
		return sports;
	}

	public void setSports(ArrayList<Sport> sports) {
		this.sports = sports;
	}

	public void ajout_sport(Sport sp) {	
		sports.add(sp);
	}
	
	public void afficher() {
		for (int i = 0; i < sports.size(); i++) {
			System.out.println(sports.get(i));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
