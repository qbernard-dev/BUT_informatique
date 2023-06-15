#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// Initialisation de toutes les constantes qui seront utilisé dans le programme
const char PION_A = '1';  
const char PION_B = '2';
const int VIDE = 0;
const char INCONNU = ' '; 

#define NBLIG 6
#define NBCOL 7
#define COLONE_DEBUT NBCOL/2

//Initiliation du tableau de jeu
typedef int t_jeu [NBLIG-1][NBCOL-1];
typedef int t_place [NBCOL-1];

//Initialisation des différentes procédures et fonctions

void initGrille (t_jeu, t_place);
void afficher (t_jeu, t_place, char, int);
int grillePleine (t_jeu);
/*
void jouer (t_jeu, char, int*, int*);
int choisirColonne (t_jeu, char, int*);
int trouverLigne (t_jeu, int);
int estVaiqueur (t_jeu, int, int);
void finDePartie(char);
*/

//Définition du programme principal
int main(){
    char vainqueur[20];
    int ligne, colonne;
    t_jeu g;
    t_place p;
    initGrille(g,p); 
    colonne = 5;
    afficher(g,p,PION_A, colonne);
    grillePleine(g);
    /*
    while ((vainqueur == INCONNU) && (grillePleine == false)){
        jouer(g&, PION_A, ligne&, colonne&);
        afficher(g, PION_B, COLONE_DEBUT);
        if (estVaiqueur(g, ligne, colonne)){
            vainqueur = PION_A;
        }
        else if(grillePleine == false){
            jouer(g&, PION_B, ligne&, colonne&);
            afficher(g, PION_A, COLONE_DEBUT);
                if (estVaiqueur(g, ligne, colonne)){
                vainqueur = PION_B;
            }        
        }
    }
    finDePartie(vainqueur);
    */
}

void initGrille (t_jeu tab, t_place tab1){
    int i,j;
    for (i = 0; i < NBLIG; i++){
        for (j = 0; j < NBCOL; j++){
            tab[i][j] = VIDE;
        }
    }
    for (i = 1; i < NBCOL+1; i++){
        tab1[i] = i;
    }
}

int grillePleine(t_jeu tab){
    int i,j;
    bool res;
    res = true;
    for (i = 0; i < NBLIG; i++){
        for (j = 0; j < NBCOL; j++){
            if(tab[i][j] == VIDE){
                res = false;
                return res;
            }
        }
    }   
    return res;
} 

void afficher(t_jeu tab, t_place tab1, char pion, int colonne){
    int i,j;
    for (i = 1; i < NBCOL+1; i++){
        if(colonne == tab1[i]){
            if(pion == PION_A){
                printf("\033[31m"); // permet de mettre le pion en rouge 
                printf("  #   ");
                printf("\033[37m"); // permet de remettre la couleur blanche
            }
            if(pion == PION_B){
                printf("\033[93m"); // permet de mettre le pion en jaune
                printf("  #   ");
                printf("\033[37m"); // permet de remettre la couleur blanche
            }
        }
        else{
            printf("  %d   ", tab1[i]);
        }
    }
    printf("\n}---------------------------------------{\n");
    for (i = 0; i < NBLIG; i++){
        for (j = 0; j < NBCOL; j++){
            tab[i][j] = '#';
            printf("[ %c ] ",tab[i][j]);
        }
        printf("\n");
    }
    printf("}---------------------------------------{\n");
}

int choisirColone()