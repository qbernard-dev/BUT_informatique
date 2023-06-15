#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 198 // 22 équipes de 9 coureurs = 198 coureurs

typedef struct{
    int c_numero;
    int c_temps;
}t_concurrent;

typedef t_concurrent t_tabconc   
    t_chaine10 c_num; // numéro de cet abonné
    int c_duree; // durée pour laquelle il est abonné[MAX];

void permuter(t_concurrent* c1, t_concurrent* c2){
    int tmp;
    tmp = (*c1).c_numero;
    (*c1).c_numero = (*c2).c_numero;
    (*c2).c_numero = tmp;
}

void insere( t_concurrent c, t_tabconc tc, int n ){
    int j;
    j = 0;
    while(j >= 1 && tc[j].c_numero != tc[j-1].c_numero){
        if(tc[j-1].c_temps < tc[j].c_temps){
            permuter(tc[j].c_numero, tc[j-1].c_numero);
        }
    }
}