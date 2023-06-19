public class Exo1_2 {
	
	public static void main(String[] args) {
		try {
			int[] tab = null;
			System.out.println(tab[2]);
		}
		catch (NullPointerException e){
			System.out.println("Tu as oubli de créer le tableau avec le new");
		}
	}
}