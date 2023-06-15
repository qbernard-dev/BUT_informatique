/**
BERNARD Quentin 1B2
le programm donne les deux meilleur joueurs du jeu de bec de macareux
il doit pourvoir mettre tous les joueurs du tournoie
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

const char FIN[4] = "FIN" ;

int main(){
    int score, score_1, score_2;
    char nom[20];
    char nom_1[20];
    char nom_2[20];
    printf("Quel est votre nom : ");
    scanf("%s",nom);
    strcpy(nom,nom_1);
    score_1 = 0;
    score_2 = 0;
    while(strcmp(nom, FIN) != 0){
        printf("Quel est votre score finale : ");
        scanf("%d",&score);
        if (score > score_1){
            score_1 = score;
            strcpy(nom,nom_1);
        }
        else if (score == score_1){
            score_2 = score;
           strcpy(nom,nom_2);
        }
        if ((score < score_1) && (score > score_2)){
            score_2 = score;
           strcpy(nom,nom_2);
        }
        printf("Quel est votre nom : ");
        scanf("%s",nom);
    }
    printf("Le vaiqueurs est : %s avec un score de %d points",nom_1, score_1);
    printf("\nLe deuxième est : %s avec un score de %d points",nom_2, score_2);
}
