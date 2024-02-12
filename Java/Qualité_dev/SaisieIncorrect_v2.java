import java.util.Scanner;

public class SaisieIncorrect_v2 {
    public static class EntierInvalideException extends Exception {
        public EntierInvalideException(String message) {
            super(message);
        }
    }
    
    public static int saisieCorrecte() {
        Scanner sc = new Scanner(System.in);
        int entier = 0;
        boolean saisieCorrecte = false;
        
        while (!saisieCorrecte) {
            try {
                System.out.print("Saisir un entier supérieur à 10 : ");
                entier = sc.nextInt();
                if (entier <= 10) {
                    throw new EntierInvalideException("L'entier doit être supérieur à 10.");
                }
                saisieCorrecte = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine(); 
            }
        }
        
        return entier;
    }
    
    public static void main(String[] args) {
        int entier = saisieCorrecte();
        System.out.println("Entier saisi : " + entier);
    }
}