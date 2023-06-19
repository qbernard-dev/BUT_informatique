
public class ProgSports {

	private int MAX;

	public ProgSports(int mAX) {
		super();
		MAX = mAX;
	}
	
	public int getMAX() {
		return MAX;
	}

	public void setMAX(int mAX) {
		MAX = mAX;
	}
	
	public static void main(String[] args) {
		LesSports a = new LesSports();
		
		a.ajout_sport(new Sport(2,"ping-pong"));
		
		
		Sport b = new Sport(2,"ping-pong");
		Sport c = new SportCo(3,"valorant",5);
		Sport d = new SportCo(4,"rl",2);
		Sport e = new SportCo(5,"pétanque",3);
		
		a.ajout_sport(b);
		a.ajout_sport(c);
		a.ajout_sport(d);
		a.ajout_sport(e);
		
		a.afficher();
		
	}
}
