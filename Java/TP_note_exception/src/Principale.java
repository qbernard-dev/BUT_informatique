import java.util.ArrayList;

public class Principale {

	
	public static void main(String[] args) {
		
		Piste p1 = new Piste("Les Marmottes",950,"vert",true);
		Piste p2 = new Piste("La Gentiane",3400,"bleu",true);
		Piste p3 = new Piste("La Genepi",6800,"bleu",true);
		Piste p4 = new Piste("La Frisson",3500,"noir",false);
		
		Domaine d1 = new Domaine("Station");
		Domaine d2 = new Domaine("San Bernardo");
		d2.ajouter(p1);
		d2.ajouter(p2);
		d2.ajouter(p3);
		d2.ajouter(p4);
		
		d2.afficher();
		
		Client c1 = new Client("LEGUIC","Eric",'A');
		Client c2 = new Client("LEGUIC","Gwen",'E');
		
		ArrayList<Client> l_client = new ArrayList<Client>(100);
		l_client.add(c1);
		l_client.add(c2);
		
		for (int i = 0; i < l_client.size(); i++) {
			l_client.get(i).afficher();
		}
		
		ForfaitLong f1 = new ForfaitLong(d2, c2, false, "10/02/2023", 7);
		f1.afficher();
		
		
		if(f1.getDomaine().est_presente("La Genepi") == 1){
			if(f1.getClient().getNom() == "Gwen") {
				if(p3.isOuvert() == true) {
					System.out.println("Gwen peut prendre la piste La Genepi");
				}
			}
		}
		else {
			System.out.println("Gwen ne peut pas prendre la piste La Genepi");
		}
		
	}

}
