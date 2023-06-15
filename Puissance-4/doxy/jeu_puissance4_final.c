#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
/*
Il y a des diffénrece avec la maquette car qaund on appuie sur la bare espace on gagne direct et je n'ai pas réussi à résoudre le problème
Affichage du mot PUISSANCE 4 modifier car bug avec les "\" dans le printf
On ne demande pas le nom des joueurs car je n'ai pas réussi à faire une partie
La grille est modfier car je trouvait plus lisible que le pion soit plus gros
*/

/**
 * \def PION_A
 * 
 * @brief constante pour le pion du joueur 1 
 * 
 */
const int PION_A = 1;  

/**
 * \def PION_B
 * 
 * @brief constante pour le pion du joueur 2
 * 
 */
const int PION_B = 2;

/**
 * \def VIDE
 * 
 * @brief constante pour initialiser la grille de jeu
 * 
 */
const int VIDE = 0;

/**
 * \def NBLIB
 * 
 * @brief constante pour initialiser le nombre de ligne 
 * 
 */
#define NBLIG 6

/**
 * \def NBCOL
 * 
 * @brief constante pour initialiser le nombre de colonne
 * 
 */
#define NBCOL 7

/**
 * \def COLONE_DEBUT
 * 
 * @brief constante pour initialiser la colonne du début (colonne où le pion apparaitra)
 * 
 */
#define COLONE_DEBUT NBCOL/2

/**
 * 
 * \typedef t_jeu
 * 
 * @brief un tableau de tableau d'entier, qui est la grille de jeu
 * 
 */
typedef int t_jeu [NBLIG][NBCOL];

/**
 * 
 * \typedef t_place
 * 
 * @brief un tableau de entier, qui affiche le numéro des colonnes au dessus de la grille de jeu
 * 
 */
typedef int t_place [NBCOL];

//Initialisation des différentes procédures et fonctions
void initGrille (t_jeu, t_place);
void afficher (t_jeu, int, int);
bool grillePleine (t_jeu);
int choisirColonne (t_jeu, int, int);
int trouverLigne (t_jeu, int);
void jouer (t_jeu, int, int*, int*);
void finDePartie(int);
bool estVainqueur (t_jeu, int, int);

//Définition du programme principal
int main(){
    int vainqueur;
    int ligne,colonne;
    bool gagne, egalite;
    t_jeu g;
    t_place gr;
    printf("PUISSANCE 4\n");
    gagne = false;
    vainqueur = VIDE;
    egalite = grillePleine(g);
    initGrille(g, gr);
    afficher(g, PION_A, COLONE_DEBUT);
        while(vainqueur == VIDE && egalite == false){
            jouer(g, PION_A, &colonne, &ligne);
            afficher(g, PION_B, COLONE_DEBUT);
            gagne = estVainqueur(g, colonne, ligne);
            printf("%d", gagne);
            if(gagne = true) {
                vainqueur = PION_A;
            } 
            else if (egalite == false){
                jouer(g, PION_B, &colonne, &ligne);
                afficher(g, PION_A, COLONE_DEBUT);
                gagne = estVainqueur(g, colonne, ligne);
                if(gagne == true) {
                    vainqueur = PION_B;
                }
            }
            egalite = grillePleine(g);
    }
    afficher(g, PION_A, COLONE_DEBUT);
    finDePartie(vainqueur);
}

/**
 * 
 * \fn void initGrille(t_jeu tab, t_place tabHaut)
 * 
 * @brief la procédure permet de d'initialiser la grille avec des 0
 * 
 * @param tab : t_jeu le tableau du jeu de puissance 4
 * @param tabHaut : t_place le tableau au dessus de la grille de jeu contenant les numéros des colones 
 */
void initGrille(t_jeu tab, t_place tabHaut){
    int i, j;
    for(i = 0 ; i < NBLIG; i++){
        for(j= 0 ;j < NBCOL; j++){
            tab[i][j] = VIDE;
        }
    }
    for(i = 1; i <= NBCOL; i++){
        tabHaut[i] = VIDE;
    }
}

/**
 * 
 * \fn bool grillePleine(t_jeu tab)
 *
 * @brief la fonction regarde si la grille est pleine 
 * 
 * @param tab : t_jeu le tableau du jeu de puissance 4
 * @return un booléen qui indique si la grille est pleine ou non
 */
bool grillePleine(t_jeu tab){
    int i, j;
    for(i = 0; i < NBLIG; i++){
        for(j = 0; j < NBCOL; j++){
            if(tab[i][j] == VIDE){
                return false;
            }
        }
    }
    return true; 
}

/**
 * 
 * \fn void afficher(t_jeu tab, int joueur, int colonne)
 * 
 * @brief la procédure permet d'afficher le tableau de jeu avec les pions 
 * 
 * @param tab : t_jeu le tableau du jeu de puissance 4
 * @param joueur : int, pion A pour le joueur 1 et pion B pour le joueur 2
 * @param colonne : int, indice de la colonne 
 */
void afficher(t_jeu tab, int joueur, int colonne){
    int i,j,k;
    for (i = 1; i <= NBCOL; i++){
        if(i == colonne){
            if(joueur == PION_A){
                printf("  %c  ", PION_A);
            } 
            else{
                printf("  %c  ", PION_B);
            }
        }
        else{
            printf("  %d  ", i);
        }

    }
    printf("\n"); 
    for (i = 0; i < NBLIG; i++){
        printf("}---------------------------------------{\n");
        for (k = 0; k < 2; k++){
            for (j = 0; j < NBCOL; j++){
                if(tab[i][j] == VIDE){
                    printf("[ %c ] ", VIDE);
                }
                else if(tab[i][j] == PION_B){
                    printf("[ %c ] ", PION_B);
                } else if(tab[i][j] == PION_A){
                    printf("[ %c ] ");
                }
            }
            printf("\n");
        }
    }
    printf("}---------------------------------------{\n");
}

/**
 * 
 * fn\ choisirColonne(t_jeu tab, int pion, int colonne)
 * 
 * @brief la fonction permet au joueur de choisir la colone où il veut joué son pion
 * 
 * @param tab : t_jeu, le tableau du jeu de puissance 4
 * @param pion : int, 1 pour le joueur 1 et 2 pour le joueur 2
 * @param colonne : int, indice de la colonne pour indiquer où le joueur veut jouer 
 * @return int : la colonne choisi par le joueur 
 */
int choisirColonne(t_jeu tab, int pion, int colonne){
    char direction, entre;
    printf("\nAppuyez sur q pour aller à droite, d pour aller a gauche et espace pour valide : ");
    scanf("%c%c", &direction, &entre);
    while (direction != ' ' && direction != 'q' && direction != 'd'){
        if(direction != 10){
            printf("\nERREUR, caractere non reconnu");        
            }
        scanf("%c%c", &direction, &entre);
    }
    while(direction != ' ') {
        if(direction == 'q'){
            if(colonne > 1){
                colonne = colonne - 1;
                afficher(tab, pion, colonne);
            } 
            else{
                printf("\nBORDURE");
                afficher(tab, pion, colonne);
            }
            printf("\nJouez : ");
            scanf("%c%c", &direction, &entre);
            while (direction != ' ' && direction != 'q' && direction != 'd'){
                if(direction != 10){
                    printf("\nERREUR, caractere non reconnu");
                    printf("\nJouez : ");
                }
            }
        }
        else if(direction == 'd'){
            if(colonne < NBCOL){
                colonne++;
                afficher(tab, pion, colonne);
            } 
            else{
                afficher(tab, pion, colonne);
                printf("\nBORDURE");
            }
            printf("\nJouez : ");
            scanf("%c%c", &direction, &entre);
            while (direction != ' ' && direction != 'q' && direction != 'd'){
                if(direction != 10){
                    printf("\nERREUR, caractere non reconnu");
                    printf("\nJouez ");
                }
                scanf("%c%c", &direction, &entre);
            }
        }
    }
    return colonne-1;
}

/**
 * 
 * fn\ int trouverLigne(t_jeu tab, int colonne)
 * 
 * @brief la fonction consiste à trouver la première case non occupée de la colonne
 * 
 * @param tab : t_jeu, le tableau du jeu de puissance 4
 * @param colonne : int, indice de la colonne 
 * @return int : indice de la ligne ou -1 si la colone est pleine 
 */
int trouverLigne(t_jeu tab, int colonne){
    int i;
    for(i = NBLIG; i >= 0; i--){
        if(tab[i][colonne] == 0){
            return i;
        }
    }
    return i = -1;
}

/**
 * 
 * \fn void jouer(t_jeu tab, int pion, int* ligne, int* colonne)
 * 
 * @brief la procédure permet de faire jouer le tour du joueur
 * 
 * @param tab : t_jeu, le tableau du jeu de puissance 4
 * @param pion : int, 1 pour le joueur 1 et 2 pour le joueur 2
 * @param ligne : int, indice de la ligne 
 * @param colonne : int, indice de la colonne
 */
void jouer(t_jeu tab, int pion, int* ligne, int* colonne){
    *colonne = choisirColonne(tab, pion, COLONE_DEBUT);
    *ligne = trouverLigne(tab, *colonne);
    if (*ligne != -1){
        tab[*ligne][*colonne] = pion;
    }
    else{
        printf("la colone est pleine");
        jouer(tab, pion, ligne, colonne);
    }
}

/**
 * 
 * \fn void finDePartie(int pion)
 * 
 * @brief la procédure affiche le texte de la fin, une victoire ou une égalité
 * 
 * @param pion : int, le pion A ou le pion B
 */
void finDePartie(int pion){
    if (pion == PION_A){
        printf("VICTOIRE !!! Bravo  pour cette partie incroyable");
    }
    else if (pion == PION_B){
        printf("VICTOIRE !!! Bravo  pour cette partie incroyable");
    }
    else{
        printf("EGALITE");
    }
}

/**
 * 
 * \fn bool estVainqueur(t_jeu tab, int colonne, int ligne)
 * 
 * @brief la fonction permet de vérifier si il y a un gagnant
 * 
 * @param tab : t_jeu, le tableau du jeu de puissance 4
 * @param colonne : int, indice de la colonne 
 * @param ligne : int, indice de la ligne
 * @return un booléen, vrai si le jouer est vainqueur et faux si il n'est pas gagnant
 */
bool estVainqueur(t_jeu tab, int colonne, int ligne){
    int i, nbPion, pion;
    nbPion = 1;
    pion = tab[ligne][colonne];
    for(i = 1; i <= 3; i++){
        if((colonne-i >= 0) && (tab[ligne][colonne-i] == pion)){
            nbPion++;
        }
    }
    for(i = 1; i <= 3; i++){
        if((colonne+i < NBCOL) && (tab[ligne][colonne+i] == pion)){
            nbPion++;
        }
    }
    if(nbPion >= 4){
        return true;
    }
    nbPion = 1;
    for(i = 1; i <= 3; i++){
        if((ligne-i >= 0) && (tab[ligne-i][colonne] == pion))
        {
            nbPion++;
        }
    }
    for(i = 1; i <= 3; i++){
        if((ligne+i < NBLIG) && (tab[ligne+i][colonne] == pion)){
            nbPion++;
        }
    }
    if(nbPion >= 4){
        return true;
    }
    nbPion = 1;
    for(i = 1; i <= 3; i++){
        if((ligne-i >= 0) && (colonne-i >= 0) && (tab[ligne-i][colonne-i] == pion)){
            nbPion++;
        }
    }
    for(i = 1; i <= 3; i++){
        if((ligne+i < NBLIG) && (colonne+i < NBCOL) && (tab[ligne+i][colonne+i] == pion)){
            nbPion++;
        }
    }
    if(nbPion >= 4){
        return true;
    }
    nbPion = 1;
    for(i = 1; i <= 3; i++){
        if((ligne-i >= 0) && (colonne+i < NBCOL) && (tab[ligne-i][colonne+i] == pion)){
            nbPion++;
        }
    }
    for(i = 1; i <= 3; i++){
        if((ligne+i < NBLIG) && (colonne-i >= 0) && (tab[ligne+i][colonne-i] == pion)){
            nbPion++;
        }
    }
    if(nbPion >= 4){
        return true;
    }
    return false;        
}