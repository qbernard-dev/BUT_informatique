import java.util.ArrayList;
import java.util.Scanner;

public class ListeEmploye {
	
    static int ligne;
    static Scanner entree=new Scanner (System.in);
	
	private ArrayList<Employe> emp = new ArrayList<Employe>(100);

	public ListeEmploye() {
		super();
	}

	public ArrayList<Employe> getEmp() {
		return emp;
	}	
	
	public void ajout(Employe em) {
		emp.add(em);
	}
	
	public void tri() {
		int i_min;
		for(int i = 0; i < emp.size() - 1; i++) {
			i_min = i;
			for(int j = i+1; j < emp.size(); j++) {
				if(emp.get(j).salaire() < emp.get(i_min).salaire()) {
					i_min = j;
				}
			}
			Employe temp = emp.get(i_min);
			emp.set(i_min, emp.get(i) );
			emp.set(i,temp);
			
		}
	}
	
	public void afficher() {
		for (int i = 0; i < emp.size(); i++) {
			System.out.println(emp.get(i));
		}
	}
	
	public void selectionner() {
		int min, max;
		System.out.println("min : ");
		ligne = entree.nextInt();
		min = ligne;
		
		System.out.println("max : ");
		ligne = entree.nextInt();
		max = ligne;
		
		
		System.out.println(min+"   "+max);
		
		for(int i = 0; i < emp.size(); i++) {
			if(emp.get(i).getAge() >= min && emp.get(i).getAge() <= max) {
				System.out.println(emp.get(i).afficher());  
			}
		}
	}
	
}
