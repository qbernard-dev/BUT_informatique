#include <stdio.h>
#include <stdlib.h>

#define N 5
typedef int vecteur[N] ;

void remplirVecteur(vecteur v){
    int val,i;
    for(i=0; i < N; i++){
        printf("Rentrez une valeure : ");
        scanf("%d", &val);
        v[i] = val;
    }
    printf("\n");
}

void afficherVecteur(vecteur v){
    int i;
    for(i=0; i < N; i++){
        printf("%d", v[i]);
        printf(" ; ");
    }
}

void sommeVecteur (vecteur v1, vecteur v2, vecteur vs){
    remplirVecteur(v1);
    remplirVecteur(v2);
    int i;
    for(i=0; i < N; i++){
        vs[i] = v1[i] + v2[i];
    }
    afficherVecteur(vs);
}

int main(){
    vecteur v1 = {};
    vecteur v2 = {};
    vecteur vs = {};
    sommeVecteur(v1,v2,vs);
}