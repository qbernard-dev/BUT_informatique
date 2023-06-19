import java.util.Scanner;

public class Exo3 {
	
	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);
		String a;		
		try {
			a = clavier.nextInt();
		}
		catch (InputMismatchException e){
			System.out.println("Tu n'as saisie un int ressaye !");
			a = clavier.nextInt();
		}
	}
}
