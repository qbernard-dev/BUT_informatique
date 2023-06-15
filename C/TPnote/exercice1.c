/**
BERNARD Quentin 1B2
le programm est le jeu de "bec de macaraux" 
le jeu a trois pssibilité :
    si un dé est égale à 3 on ajoute 10 points
    si un dé est égale à 1 on retire 10 points 
    si un dé est égale à 6 on double les points 
*/

#include <stdio.h>
#include <stdlib.h>
const int DE3 = 3;
const int DE1 = 1;
const int DE6 = 6;
const int VMIN = 1;
const int VMAX = 6;

int main(){
    int de1, de2, points;
    points = 0;
    printf("Valeur du premier dé : ");
    scanf("%d",&de1);
    printf("Valeur du second dé : ");
    scanf("%d",&de2);
    while ((VMIN <= de1) && (de1 > VMAX)){
        if ((de1 < VMIN) || (de1 > VMAX)){
            printf("Valeur du premier dé : ");
            scanf("%d",&de1);
        }
    }
    while ((VMIN <= de2) && (de2 > VMAX)){
        if ((de2 < VMIN) || (de2 > VMAX)){
            printf("Valeur du second dé : ");
            scanf("%d",&de2);
        }
    }
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
    printf("Votre score est de %d",points);
}