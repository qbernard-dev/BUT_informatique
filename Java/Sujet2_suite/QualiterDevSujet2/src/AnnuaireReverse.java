import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AnnuaireReverse {
	private String nom;
	private Map<String, Abonne> dic;
	
	public AnnuaireReverse(String nom) {
		this.nom = nom;
		this.dic = new HashMap<>(); 
	}
	
	public void inscrire(Abonne abo) {
 	     Iterator<NumTel> it = abo.getHset().iterator();
 	     while(it.hasNext()){
 	    	this.dic.put(it.next().getValeur(), abo);
 	     }
	}
	
	public void desinscrire(Abonne abo) {
		for (Map.Entry<String, Abonne> entry : dic.entrySet()) {
		    String key = entry.getKey();
		    Abonne value = entry.getValue();
		    if(abo.hashCode() == value.hashCode()) {
				this.dic.remove(key);
			}
		}
	}
	
	public void All() {
		System.out.println("Abonner :");
		System.out.println(dic.toString());
	}
	
	public Abonne qui(String numero) {
		for (Map.Entry<String, Abonne> entry : dic.entrySet()) {
			String key = entry.getKey();
			Abonne value = entry.getValue();
		    if(key.contains(numero)) {
		    	System.out.println("a qui :");
		    	return value;
		    }
		}
		return null;
	}
	
	public static void main(String[] args) {
		AnnuaireReverse a = new AnnuaireReverse("Jean");
		Abonne b = new Abonne("Jean","Neymar");
		b.addNum();
		b.mesNums();
		a.inscrire(b);
		a.All();
		System.out.println(a.qui("0609708256"));
		a.All();
		System.out.println("desinscription");
		a.desinscrire(b);
		a.All();
	}
	
}
