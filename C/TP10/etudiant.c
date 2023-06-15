#include <stdio.h>
#include <stdlib.h>

typedef char chaine20[21] ;
typedef struct {
    chaine20 nom;
    chaine20 prenom;
    int age;
} etudiant ; 

void affiche(etudiant e){
    printf("Etudiant : %s, %s, %dans.\n", e.nom, e.prenom, e.age);
}

void remplir(etudiant *e){
    printf("Nom : ");
    scanf("%s", (*e).nom);
    printf("Prenom : ");
    scanf("%s", (*e).prenom);
    printf("Age : ");
    scanf("%d", &(*e).age);
}

int compare(etudiant e1, etudiant e2){
    int res;
    if(e1.age == e2.age){
        res = 0;
    }
    if(e1.age > e2.age){
        res = 1;
    }
    if(e1.age < e2.age){
        res = -1;
    }
    return res;
}

int main(){
    int res;
    etudiant e1 = {};
    etudiant e2 = {};
    remplir(&e1);
    affiche(e1);
    remplir(&e2);
    affiche(e2);
    res = compare(e1, e2);
    if(res == 0){
        printf("Les étudiants ont le même âge");
    }
    if(res == 1){
        printf("Le premier étudiant est plus âgé");
    }
    if(res == -1){
        printf("Le deuxième étudiant est plus âgé");
    }
}