#include <stdio.h>
#include <stdlib.h>

const int FIN = 50;

void faireJouer(char j[], int *score){
    int de;
    printf("Quelle est la valeur du dé : ");
    scanf("%d", &de);
    if (de < 1 || de > 6){
        while (de < 1 || de > 6){
            printf("recommencez : ");
            scanf("%d", &de);
        }
    }
    else if (de == 6){
        while (de == 6){
            if (*score >= FIN){
                break;
            }
            printf("rejouer : ");
            scanf("%d", &de);
                if (de < 1 || de > 6){
            while (de < 1 || de > 6){
                printf("recommencez : ");
                scanf("%d", &de);
            }
    }
            *score = *score + de;
        }
    }
    *score = *score + de;
}

void afficherResultat(int score1, int score2){
    printf("Le joueur A a %d points et le joueur B a %d points", score1, score2);
    if (score1 == FIN){
        printf("Le Vainqueur est le joueur A");
    }    
    if (score2 == FIN){
        printf("Le Vainqueur est le joueur B");
    } 
}

int main(){
    int score1, score2 ;
    char j1[20];
    char j2[20];
    score1 = 0;
    score2 = 0;
    printf("Quel est votre nom J1 : ");
    scanf("%s",j1);
    printf("Quel est votre nom J2 : ");
    scanf("%s",j2);
    while (score1 <= FIN && score2 <= FIN){
        faireJouer(j1, &score1);
        if (score1 <= FIN){
            faireJouer(j2, &score2);
        }
    }
    afficherResultat(score1, score2);
}