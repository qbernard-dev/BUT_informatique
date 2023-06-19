import java.util.Scanner;
public class Exo1 {
	
	public static void main(String[] args) {
		int a, b, res;
		Scanner clavier = new Scanner(System.in);
		a = clavier.nextInt(); b = clavier.nextInt();
		try {
			res = a / b;
			System.out.println("le résultat de " + a + " divisé par " + b + " est " + res);
		}
		catch (ArithmeticException e) {
			System.out.println("Alerte, c'est une division par 0 !!");
		}
		
		System.out.println ("Fin du programme") ;
	}
}

/* Question 1 : 
L'exception est de type Arithmetic, car on fait une division par 0
*/