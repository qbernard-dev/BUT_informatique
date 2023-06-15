#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 9
typedef int tableau[N] ;

const tableau BILLET = {500,200,100,50,20,10,5,2,1};
const char FIN[2] = "*";

void initTab(tableau total){
    int i;
    for(i = 0; i < N; i++){
        total[i] = 0;
    }
}

void client(tableau total, int val){
    int reste,i,nbBillet;
    i = 0;
    while(val != 0){
        nbBillet = val / BILLET[i];
        if(nbBillet != 0){
            printf("%d x %d\n", nbBillet, BILLET[i]);
            total[i] = total[i] + nbBillet;
        }
        val = val % BILLET[i];
        i++;
    }
}

void afficheTab(tableau t){
    int i;
    for(i=0; i < N; i++){
        if(t[i] != 0){
            printf("%d", BILLET[i]);
        }
    }
}

void afficheTotal(tableau t, tableau b){
    int i;
    for(i=0; i < N; i++){
        printf("%d x %d\n", t[i], b[i]);
    }
}

int main(){
    tableau total = {};
    int somme;
    char nom[20];
    initTab(total);
    printf("entrez votre nom : ");
    scanf("%s", nom);
    while(strcmp(nom, FIN) != 0){
        printf("entrez le montant : ");
        scanf("%d", &somme);
        client(total, somme);
        printf("entrez votre nom : ");
        scanf("%s", nom);
    }
    afficheTotal(total,BILLET);
}

