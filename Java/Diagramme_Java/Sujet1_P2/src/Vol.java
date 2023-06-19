import java.util.ArrayList;

public class Vol {

	private int numVol;
	private Aeroport ae;
	private Avion av;
	private ArrayList<Personne> pers;

	

	public Vol(int numVol, Aeroport ae, Avion av, ArrayList<Personne> pers) {
		this.numVol = numVol;
		this.ae = ae;
		this.av = av;
		this.pers = new ArrayList<Personne>(100);
	}

	public int getNumVol() {
		return numVol;
	}

	public Aeroport getAe() {
		return ae;
	}

	public Avion getAv() {
		return av;
	}

	public ArrayList<Personne> getPers() {
		return pers;
	}

	@Override
	public String toString() {
		return "Vol [numVol=" + numVol + ", ae=" + ae + ", av=" + av + ", pers=" + pers + "]";
	}

	public void ajoutP(Personne p) {
		pers.add(p);
	}
	
	public void supprP(Personne p) {
		pers.remove(p);
	}
	
	public void ajoutPass(Personne p) {
		for (int i = 0; i < pers.size(); i++) {
			if(!pers.get(i).getNumPasseport().equals(p.getNumPasseport())) {
				ajoutP(p);
			}
		}
	}
	
	public void supprPass(Personne p) {
		for (int i = 0; i < pers.size(); i++) {
			if(!pers.get(i).getNumPasseport().equals(p.getNumPasseport())) {
				supprP(p);
			}
		}
	}
	
	public void modiAssurerPar(Avion a) {
		this.av = a;
	}
	
}
