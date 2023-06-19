import java.util.ArrayList;
import java.util.Date;

public class Reservation {

	private Date dater;
	private ArrayList<Restaurant> rest;
	
	public Reservation(Date dater, ArrayList<Restaurant> rest) {
		this.dater = dater;
		this.rest = rest;
	}

	public Date getDater() {
		return dater;
	}

	public ArrayList<Restaurant> getRest() {
		return rest;
	}
	
	private void ajoutRestaurant(Restaurant r) {
		rest.add(r);
	}
	
	private void suppRestaurant(Restaurant r) {
		rest.remove(r);
	}
}
