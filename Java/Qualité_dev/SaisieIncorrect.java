import java.util.InputMismatchException;
import java.util.Scanner;

public class SaisieIncorrect {
    public static void main(String[] args) {
        int entier = saisieCorrecte();
        System.out.println("L'entier saisi est : " + entier);
    }

    public static int saisieCorrecte() {
        Scanner sc = new Scanner(System.in);
        int entier = 0;
        boolean saisieCorrecte = false;
        do {
            try {
                System.out.print("Veuillez saisir un entier supérieur à 10 : ");
                entier = sc.nextInt();
                if (entier <= 10) {
                    throw new IllegalArgumentException("Tu sais ce qu'un entier au-dessus de 10 ?");
                }
                saisieCorrecte = true;
            } catch (InputMismatchException e) {
                System.out.println("Vous devez saisir un entier !");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!saisieCorrecte);
        return entier;
    }
    public static void main1(String[] args) {
        int entier = saisieCorrecte();
        System.out.println("Entier saisi : " + entier);
    }
}