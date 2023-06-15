#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define NB_LIGNE 10
#define NB_COLONNE 20
typedef int tab[NB_LIGNE][NB_COLONNE] ;

void initialier(tab t){
    int i, j, val;
    val = 0;
    for(i=0; i < NB_LIGNE; i++){
        for(j=0; j < NB_COLONNE; j++){
            val = i + j;
            t[i][j] = val;
        }
    }
}

void afficher(tab t){
    int i, j, val;
    for(i=0; i < NB_LIGNE; i++){
        for(j=0; j < NB_COLONNE; j++){
            printf(" %d ", t[i][j]);
        }
    printf("\n");
    }
}

bool existe(tab t, int val){
    bool res;
    int i,j;
    res = false;
    for(i=0; i < NB_LIGNE; i++){
        for(j=0; j < NB_COLONNE; j++){
            if(t[i][j] == val){
                res = true;
                return res;
            }
        }
    }
    return res;
}

int main(){
    bool res;
    int val;
    tab t = {} ;
    initialier(t);
    afficher(t);
    printf("\nQuelle valeur cherchez vous : ");
    scanf("%d", &val);
    res = existe(t, val);
    printf("\n0 pour faux et 1 pour vrai : %d\n", res);
}