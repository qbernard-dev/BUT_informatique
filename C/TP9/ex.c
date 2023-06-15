#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define NB_LIGNE 10
#define NB_COLONNE 10
typedef float t_matrice[NB_LIGNE][NB_COLONNE] ;
typedef float t_vecteur [NB_LIGNE];

void afficherVecteur(t_vecteur v, int n){
    int i ;
    for(i=0; i < n; i++){
        printf(" %.2f ", v[i]);
    }
}

void afficherMatrice(t_matrice m, int n){
    int i, j;
    for(i=0; i < n; i++){
        for(j=0; j < n; j++){
            printf(" %.2f ", m[i][j]);
        }
    printf("\n");
    }
}

void produitVectMat(t_vecteur v, t_matrice m, t_vecteur r, int n){
    int i, j;
    for(i=0; i < n; i++){
        r[i] = 0;
        for(j=0; j < n; j++){
            r[i] = r[i] + v[j] * m[i][j];
        }    
    }
}

void copiervecteur(t_vecteur vi,t_vecteur vr,int n){
    int i;
    for(i=0; i < n; i++){
        vr[i] = vi[i];
    }
}

int main(){
    int i;
    t_vecteur t = {35,25,20,20};
    t_matrice t2 = {{0.9, 0.06, 0.08, 0.05},
                    {0.03, 0.8, 0.02, 0.03},
                    {0.02, 0.03, 0.75, 0.04},
                    {0.05, 0.11, 0.15, 0.88}};
    t_vecteur t_2052 = {};
    for(i=0; i <= 30; i++){
        produitVectMat(t, t2, t_2052, 4);
        copiervecteur(t_2052, t, 4);
    }
    afficherVecteur(t_2052, 4);
}