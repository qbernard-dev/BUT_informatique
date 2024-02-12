package td4;

public class Banque {
    public static void main(String[]args){
        Personne p1 = new Personne("Dupond", "Tom", "Lannion");
        Personne p2 = new Personne("Durand", "Lili", "Peros");

        p1.afficher();
        p2.afficher();

        System.out.println("Compte courant");
        Compte c1 = new Compte("111",p1);
        c1.afficher();
        c1.deposer(10000.00);
        c1.afficher();
        c1.retirer(100.00);
        c1.afficher();

        System.out.println("Compte Rémunéré");
        CompteRemunere c2 = new CompteRemunere("222",p2,3.5);
        c2.afficher();
        c2.deposer(300.00);
        c2.afficher();
        c2.retirer(50.00);
        c2.afficher();

        Entreprise e1 = new Entreprise("Holding", p1);
        e1.afficher();
    }
}
