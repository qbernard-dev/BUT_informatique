import java.util.Scanner;

public class Moyenne {

	static float moyenne (String [] valeurs) {
		float moy = 0;
		int res = 0;
		
		for (int i = 0; i < valeurs.length; i++) {
			try {
				res += Integer.parseInt(valeurs[i]);
			}
			catch (NumberFormatException e){
				System.out.println("Le nombre n'est pas de type int");
			}
		}
		
		moy = (float)(res / valeurs.length);
		return moy; 
	}
	
	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);
		/*
		String [] val = new String [4];
		val[0] = "0";
		val[0] = "5";
		val[0] = "15";
		val[0] = "20";
		*/

		System.out.println("moyenne : "+moyenne(args));
	}
}
