import java.io.*;
import java.util.Scanner; 

public class Td1_exo2 {
    public static void main(String[] args) throws IOException {
        String ligne;
        int longuer;
        StringBuffer buff;
        char car;
        int i;
        Scanner entree = new Scanner(System.in);
        System.out.println("chaîne à tester : ");
        ligne = entree.next();
        longuer = ligne.length();
        buff = new StringBuffer(ligne);
        for (i=0; i < longuer; i++){
            car = ligne.charAt(i);
            buff.setCharAt(longuer - i - 1, car);
        }
        System.out.println("L'inverse est "+buff);
        if (ligne.equals(buff.toString())){
            System.out.println("palindrome");
        }
        else{
            System.out.println("pas palindrome");
        }
        entree.close();
    }
}
