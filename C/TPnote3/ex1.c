/*
BERNARD Quentin 1B2
le programme initialise et compte la deuxième diagonale d'une matrice
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define TAILLE 5 
typedef int Matrice[TAILLE][TAILLE];

void init(Matrice m){
    int i,j;
    for (i=0; i < TAILLE; i++){
        for (j=0; j < TAILLE; j++){
            m[i][j] = 5*i-3*j+1;
        }
    }
}

int sommeDiagonale(Matrice m){
    int i,j, somme;
    somme = 0;
    i = TAILLE-1;
    for (j=0; j<TAILLE; j++){
        somme = somme + m[i][j];
        i--;
    }
    return somme;
}

bool estPresente(Matrice m, int val){
    int i,j;
    bool present ;
    present = false;
    while (present == false && i < TAILLE){
        for (j=0; j <= TAILLE; j++){
            if (m[i][j] == val){
                present = true;
                return present;
            }
        }
        i++;
    }
    return present;
}

int main(){
    Matrice m;
    int somme;
    int val = 9;
    bool present;
    init(m);
    somme = sommeDiagonale(m);
    present = estPresente(m, val);
    printf("La somme de la deuxième diagonale : %d \nLa valeur est présete 0 = false et 1 = true :%d",somme, present);
}