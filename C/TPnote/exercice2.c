/**
BERNARD Quentin 1B2
le programm est une partie avec 93 lancé de deux dé:
    on additionne le nombre de fois que le score est positif ou négatif 
    on fait la moyenne du score  
*/

#include <stdio.h>
#include <stdlib.h>

const int DE3 = 3;
const int DE1 = 1;
const int DE6 = 6;
const int VMIN = 1;
const int VMAX = 6;
const int FIN = 93;

int main(){
    char nom[20];
    int de1, de2, points, positif, negatif, compteur, total;
    float moyenne;
    compteur = 1;
    positif = 0;
    negatif = 0;
    total = 0;
    printf("Quelle est votre nom : ");
    scanf("%s",nom);
    while (compteur <= FIN){
        points = 0;
        printf("Valeur du premier dé : ");
        scanf("%d",&de1);
        printf("Valeur du second dé : ");
        scanf("%d",&de2);
        points = de1 + de2;
        if ((de1 == DE3) || (de2 == DE3)){
            points = points + 10;
        }
        if ((de1 == DE1) || (de2 == DE1)){
            points = points - 10 ;
        }
        if ((de1 == DE6) || (de2 == DE6)){
            printf("BEC DE MACRAUX");
            points = points * 2;
        }
        if (points < 0){
            negatif++;
        }
        else{
            positif++;
        }
        compteur++;
        total = total + points;
    }
    moyenne = total /(FIN*1.0);
    printf("Joueur : %s  \n%d scores négatifs  \n%d scores positifs  \nScore moyen : %.2f points",nom, negatif, positif, moyenne);
}