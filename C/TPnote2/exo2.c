/*
BERNARD Quentin 1B2
le programme est un je du yams simplier et automatiser :
    on joue a deux, chaque personne à un tableau de valeur de dé
    on utilise plusieur fonction pour calculer le gagnant :
        - un 6 ajoute 10 points
        - un yams ajoute 50 points
        - un brelan 30 points à condition qu'il n'y ai pas de yams 
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

// définition des constantes et du tableau
#define N 5
typedef int combinaison[N];
const int BORNE = 6;
const int VRAI = 1;
const int DE6 = 6;

// procédure qui initialise les dés d'un joueur
void lancer(int borne ,combinaison tab){
    int de, i;
    for (i=0; i < N; i++){
        de = rand() % borne;
        tab[i] = de+1;
    }
}

// procédure qui permet d'afficher les dés d'un joueur
void afficher(combinaison tab){
    int i;
    printf("---------------------\n|");
    for(i=0; i < N; i++){
        printf(" %d |", tab[i]);
    }
    printf("\n---------------------\n");
}

// fonction qui renvoie vrai si l'un des dé du joueur est 6, sinon renvoie faux 
bool contient(combinaison cb, int val){
    bool res;
    res = false;
    int i;
    for (i=0; i < N; i++){
        if(cb[i] == val){
            res = true;
            return res;
        }
    }
    return res;
}

// fonction qui renvoie vrai si le joueur à les 5 dés de la même valeurs, sinon renvoie faux 
bool yams(combinaison cb){
    bool res;
    int i, compteur;
    res = false;
    for(i=0; i < N-1; i++){
        if(cb[i] == cb[i+1]){
            compteur++;
        }
    }
    if(compteur == N){
        res = true;
    }
    return res;
}

// fonction qui renvoie vrai si le joueur à au moins 3 dés de la même valeurs mais pas les 5, sinon renvoie faux 
bool brelan(combinaison cb){
    bool res;
    int i, j, compteur;
    res = false;
    for(i=0; i < N; i++){
    compteur = 0;
        for(j=0; j < N; j++){
            if(cb[i] == cb[j]){
                compteur++;
            }
        }
        if(compteur >= 3){
            res = true;
            return res;
        }
    }
    return res;
}

// procédure qui permet de calculer le score d'un joueur
void calculScrore(combinaison cb, int *score){
    bool res;
    *score = 0;
    res = yams(cb);
    if (res == VRAI){
        *score = 50;
    }
    else{
        res = brelan(cb);
        if (res == VRAI){
            *score = 30;
        }
    }
    res = contient(cb, DE6);
    if (res == VRAI){
        *score = *score + 10;
    }

}

// fonction qui renvoie soit 0, soit -1 ou 1 ce qui permet de déterminier le vainqueur
int compare(combinaison cb1, combinaison cb2){
    int res, score1, score2;
    score1 = 0;
    score2 = 0;
    calculScrore(cb1, &score1);
    calculScrore(cb2, &score2);
    if(score1 == score2){
        res = 0;
        return res;
    }
    if(score1 < score2){
        res = -1;
        return res;
    }
    if(score1 > score2){
        res = 1;
        return res;
    }
}

// programme principal
int main(){
    // initialisation des variables
    bool res;
    int score;
    score = 0;
    combinaison tab1, tab2;
    srand(time(NULL));

    // initialisation des tableaux qui continnes les dés
    lancer(BORNE,tab1);
    afficher(tab1);
    lancer(BORNE,tab2);
    afficher(tab2);

    // corps du programme
        // vérification si l'un des deux joueurs à un 6
    res = contient(tab1, DE6);
    if (res == VRAI){
        printf("\nLa combinaison 1 contient un 6");
    }
    res = contient(tab2, DE6);
    if (res == VRAI){
        printf("\nLa combinaison 2 contient un 6");
    }

        // vérification si l'un des deux joueurs à les 5 dés de la même valeurs
    res = yams(tab1);
    if (res == VRAI){
        printf("\nLa combinaison 1 contient un yams");
    }
    res = yams(tab2);
    if (res == VRAI){
        printf("\nLa combinaison 2 contient un yams");
    }

        // vérification si l'un des deux joueurs à au moins 3 dés de la même valeurs mais pas les 5 dés
    res = brelan(tab1);
    if (res == VRAI){
        printf("\nLa combinaison 1 contient un brelan");
    }
    res = brelan(tab2);
    if (res == VRAI){
        printf("\nLa combinaison 2 contient un brelan");
    }

    // Calcul des scores pour connaitre le joueur vainqueur ou si il y a une égalité
    score = compare(tab1, tab2);
    if(score == 0){
        printf("\nLes scores sont égaux\n");
    }
    if(score == -1){
        printf("\nLa combinason 2 a gagné\n");
    }
    if(score == 1){
        printf("\nLa combinason 1 a gagné\n");
    }
}