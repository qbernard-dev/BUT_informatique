import java.io.*;
import java.util.Scanner; 

public class Td1{
    public static void main(String[] args) throws IOException {
        StringBuffer buff;
        char car;
        int i;
        int pos;
        String ligne;
        final int DECALAGE = 2;

        Scanner entree = new Scanner(System.in);

        System.out.println("Votre chaîne à coder : ");
        ligne = entree.next();
        buff = new StringBuffer(ligne);

        for (i=0; i < buff.length()-1; i++){
            car = buff.charAt(i);
            pos = (int)(Character.toLowerCase(car)) - (int)'a';
            pos = (pos + DECALAGE) %26;
            car = (char)((int)'a'+pos);
                   buff.setCharAt(i,car);
        }
        ligne = new String(buff);
        System.out.println("chaîne coder : "+ligne);
    }
}

