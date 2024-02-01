#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

// les constantes
#define NB_LIGNES 6
#define NB_COLONNES 7
#define DEBUT NB_COLONNES/2
#define PION_A 'X'
#define PION_B 'O'
#define VIDE ' '
#define INCONNU ' '


// les types
typedef int Grille[NB_LIGNES][NB_COLONNES];

// prototypes des fonctions
void initGrille(Grille laGrille);
void afficher(Grille laGrille, char pion);
bool grillePleine(Grille laGrille);
void jouer(Grille laGrille, char pion, int * ligne, int * colonne);
void faireJouerA(Grille laGrille, char pion, int * ligne, int * colonne);
void faireJouerB(Grille laGrille, char pion, int * ligne, int * colonne);
int choisirColonne(Grille laGrille, char pion);
int choisirColonneStrategie1(Grille laGrille, char pion);
int choisirColonneStrategie2(Grille laGrille, char pion);
int choisirColonneStrategie3(Grille laGrille, char pion);
int choisirColonneStrategie4(Grille laGrille, char pion);
int chercherLigne(Grille laGrille, int col);
bool estVainqueur(Grille laGrille, int lig, int col);
void finDePartie(char vainqueur);


// Programme principal. C'est le pion A qui commence à jouer
int main(){
    int i;
    int vic_A, vic_B;
    vic_A = 0;
    vic_B = 0;
    for(i=0; i < 100; i++){
        Grille laGrille;
        char vainqueur=INCONNU;
        int ligne, colonne, nb_pion_A, nb_pion_B;
        nb_pion_A = 0;
        nb_pion_B = 0;
        srand(time(NULL));
        initGrille(laGrille);
        afficher(laGrille, PION_A);
        while (vainqueur==INCONNU && !grillePleine(laGrille)){
            faireJouerA(laGrille,PION_A, &ligne, &colonne);
            afficher(laGrille, PION_B);
            nb_pion_A++;
            if (estVainqueur(laGrille, ligne, colonne) ){
                vainqueur = PION_A;
                vic_A++;
            } 
            else if (!grillePleine(laGrille)){
                faireJouerB(laGrille, PION_B, &ligne, &colonne);
                afficher(laGrille, PION_A);
                nb_pion_B++;
                if (estVainqueur(laGrille, ligne, colonne) ){
                    vainqueur = PION_B;
                    vic_B++;
                }
            }
        }
        finDePartie(vainqueur);
        if(vainqueur == PION_A){
            printf("Nombre de pions joués : %d", nb_pion_A);
        }
        if(vainqueur == PION_B){
            printf("Nombre de pions joués : %d", nb_pion_B);
        }
    }
    printf("\n");
    printf("J1 : %d  J2 : %d ", vic_A, vic_B);
    system(EXIT_SUCCESS);
}


void initGrille(Grille laGrille){
    int l, c;
    for (l=0 ; l<NB_LIGNES ; l++){
        for (c=0 ; c<NB_COLONNES ; c++){
            laGrille[l][c] = VIDE;
        }
    }
}

void afficher(Grille laGrille, char pion){
    int l, c;
    system("cls");  // changer en "clear" sur Linux
    printf("\t");
    printf("  %c\n", pion);
    printf("\t\xDA");
    for (c=0; c<NB_COLONNES-1 ; c++){
        printf("\xC4\xC4\xC4\xC2");
    }
    printf("\xC4\xC4\xC4\xBF\n");
    for (l=0 ; l<NB_LIGNES-1 ; l++){
        printf("\t");
        for (c=0; c<NB_COLONNES ; c++){
            printf("\xB3 %c ", laGrille[l][c]);
        }
        printf("\xB3\n");
        printf("\t\xC3");
        for (c=0; c<NB_COLONNES-1 ; c++){
            printf("\xC4\xC4\xC4\xC5");
        }
        printf("\xC4\xC4\xC4\xB4\n");
    }
    printf("\t");
    for (c=0; c<NB_COLONNES ; c++){
        printf("\xB3 %c ", laGrille[l][c]);
    }
    printf("\xB3\n");
    printf("\t\xC0");
    for (c=0; c<NB_COLONNES-1 ; c++){
        printf("\xC4\xC4\xC4\xC1");
    }
    printf("\xC4\xC4\xC4\xD9\n");
    printf("\t");
    for (c=0; c<NB_COLONNES ; c++){
        printf("  %d ", c);
    }
    printf("\n\n");
}

bool grillePleine(Grille laGrille){
    bool plein = true;
    int c = 0;
    while (plein && c<NB_COLONNES){
        if (laGrille[0][c] == VIDE){
            plein = false;
        }
        c++;
    }
    return plein;
}

void jouer(Grille laGrille, char pion, int * ligne, int * colonne ){
   *ligne = -1;
    do {
        *colonne = choisirColonne(laGrille, pion);
        *ligne = chercherLigne(laGrille, *colonne);
    }while (*ligne==-1);
    laGrille[*ligne][*colonne] = pion;
}

void faireJouerA(Grille laGrille, char pion, int * ligne, int * colonne ){
   *ligne = -1;
    do {
        *colonne = choisirColonneStrategie1(laGrille, pion);
        *ligne = chercherLigne(laGrille, *colonne);
    }while (*ligne==-1);
    laGrille[*ligne][*colonne] = pion;
}

void faireJouerB(Grille laGrille, char pion, int * ligne, int * colonne ){
   *ligne = -1;
    do {
        *colonne = choisirColonneStrategie2(laGrille, pion);
        *ligne = chercherLigne(laGrille, *colonne);
    }while (*ligne==-1);
    laGrille[*ligne][*colonne] = pion;
}

int choisirColonne(Grille laGrille, char pion){
    int col;

    do{
        printf("Numero de colonne ? ");
        scanf("%d", &col);
    } while (col<0 ||col>6);
    return col;
}

int choisirColonneStrategie1(Grille laGrille, char pion){
    int col,i;
    i=0;
    while(i<NB_COLONNES){
        col = chercherLigne(laGrille, i);
        if(col != 1){
            return i;
        }
        i++;
    }
    return col;
}

int choisirColonneStrategie2(Grille laGrille, char pion){
    int i, max, imax, tmp;
    max = chercherLigne(laGrille, 0);
    imax = 0;
    for(i=1; i < NB_COLONNES; i++){
        tmp = chercherLigne(laGrille, i);
        if (tmp>max){
            max = tmp;
            imax = i;
        }
    }
    return imax;
}

int choisirColonneStrategie3(Grille laGrille, char pion){
    int col_d = 3;
    int col_g = 3;
    int res = -1;
    while(res == -1){
        if(choisirColonne(laGrille, col_d)==-1){
            if(choisirColonne(laGrille, col_g)==-1){
                col_d++;
                col_g--;
            }
            else{
                res = col_g;
                return res;
            }
        }
        else{
            res = col_d;
            return res;
        }
    }

}

int choisirColonneStrategie4(Grille laGrille, char pion){
    int res;
    res = rand() % NB_COLONNES-1;
    return res;
}

int stratQuent1(Grille laGrille){
    int tour;
    char pion;
    tour = 0;
    for (int i = 0; i < NB_COLONNES; i++){
        if (laGrille[i][NB_LIGNES] != VIDE){
            tour++;
        }
    }
    if (tour == 0){
        pion = PION_A;
        return 4;
    }
    else if (tour == 1){
        pion = PION_B;
        if(laGrille[4][NB_LIGNES] == VIDE){
            return 4;
        }
        else{
            return 5;
        }
    }

    if (tour == 2){
        if(laGrille[4][NB_LIGNES] != VIDE && laGrille[4][NB_LIGNES-1] == VIDE){
            return 4;
        }
        else if (laGrille[3][NB_LIGNES] != VIDE && laGrille[3][NB_LIGNES-1] == VIDE){
            return 3;
        }
        else{
            return droite_pion(laGrille, pion) ;
        }
    }
}

int droite_pion(Grille LaGrillle, char pion){
    for (int i = 0; i < NB_COLONNES; i++){
        if(LaGrillle[i][NB_LIGNES] == pion){
            return i+1;
        }
    }
}

int haut_dessus(Grille LaGrille, char pion){
    for (int j = NB_LIGNES; j < 0; i--){
        for (int i = 0; i < NB_COLONNES; i++){
            if (LaGrille[i][j] == pion && LaGrille[i+1][j] == VIDE){
                return i;
            }
        }
    }
}


int bloquer(Grille LaGrille, char pion){
    // consiste à regarder si une ligne de 4 pions s'est formée autour du pion qui vient de tomber en (lig, col)
    char lePion = laGrille[lig][col];
    int cpt,i,j;

    // regarder la verticale, en comptant le nombre de pions au Sud (inutile de regarder au Nord du pion qui vient de tomber)
    i = lig;
    cpt = 0;
    while (i<NB_LIGNES && laGrille[i][col]==lePion){
        cpt++;
        i++;
    }
    if (cpt>=2){
        if (laGrille[i+1][col] == VIDE){
            return i;
        }
    }
    // regarder l'horizontale, en comptant le nombre de pions à l'Est et à l'Ouest
    j = col;
    cpt = 0;
    // on regarde à l'est
    while (j>=0 && laGrille[lig][j]==lePion){
        cpt++;
        j--;
    }
    if (cpt>=2){
        if (LaGrille[lig][j-1] )== VIDE){
            return j-1;
        }
    }
    j = col+1;
    // on regarde à l'ouest
    while (j<NB_COLONNES && laGrille[lig][j]==lePion){
        cpt++;
        j++;
    }
    if (cpt>=2 ){
        if (LaGrille[lig][j+1] == VIDE){
            return j+1;
        }      
    }
    // regarder la diagonale descendante, en comptant le nombre de pions au Nord Ouest et au Sud Est
    i = lig;
    j = col;
    cpt = 0;
    // on regarde au Nord Ouest
    while (j>=0 && i>=0 && laGrille[i][j]==lePion){
        cpt++;
        i--;
        j--;
    }
    i = lig+1;
    j = col+1;
    // on regarde au Sud Est
    while (i<NB_LIGNES && j<NB_COLONNES && laGrille[i][j]==lePion){
        cpt++;
        i++;
        j++;
    }
    if (cpt>=2 ){
        if (LaGrille[i+1][j+1] == VIDE){
            return i;
        }
    }
    // regarder la diagonale descendante, en comptant le nombre de pions au Nord Est et au Sud Ouest
    i = lig;
    j = col;
    cpt = 0;
    // on regarde au Nord Est
    while (j<NB_COLONNES && i>=0 && laGrille[i][j]==lePion){
        cpt++;
        i--;
        j++;
    }
    i = lig+1;
    j = col-1;
    // on regarde au Sud Ouest
    while (i<NB_LIGNES && j<NB_COLONNES && laGrille[i][j]==lePion){
        cpt++;
        i++;
        j--;
    }
    if (cpt>=4 ){
        return true;
    }
    return false;
}

int chercherLigne(Grille laGrille, int col){
    int ligne = -1;

    while (ligne<NB_LIGNES-1 && laGrille[ligne+1][col]==VIDE){
        ligne++;
    }
    return ligne;
}

bool estVainqueur(Grille laGrille, int lig, int col){
    // consiste à regarder si une ligne de 4 pions s'est formée autour du pion qui vient de tomber en (lig, col)
    char lePion = laGrille[lig][col];
    int cpt,i,j;

    // regarder la verticale, en comptant le nombre de pions au Sud (inutile de regarder au Nord du pion qui vient de tomber)
    i = lig;
    cpt = 0;
    while (i<NB_LIGNES && laGrille[i][col]==lePion){
        cpt++;
        i++;
    }
    if (cpt>=4){
        return true;
    }
    // regarder l'horizontale, en comptant le nombre de pions à l'Est et à l'Ouest
    j = col;
    cpt = 0;
    // on regarde à l'est
    while (j>=0 && laGrille[lig][j]==lePion){
        cpt++;
        j--;
    }
    j = col+1;
    // on regarde à l'ouest
    while (j<NB_COLONNES && laGrille[lig][j]==lePion){
        cpt++;
        j++;
    }
    if (cpt>=4 ){
        return true;
    }
    // regarder la diagonale descendante, en comptant le nombre de pions au Nord Ouest et au Sud Est
    i = lig;
    j = col;
    cpt = 0;
    // on regarde au Nord Ouest
    while (j>=0 && i>=0 && laGrille[i][j]==lePion){
        cpt++;
        i--;
        j--;
    }
    i = lig+1;
    j = col+1;
    // on regarde au Sud Est
    while (i<NB_LIGNES && j<NB_COLONNES && laGrille[i][j]==lePion){
        cpt++;
        i++;
        j++;
    }
    if (cpt>=4 ){
        return true;
    }
    // regarder la diagonale descendante, en comptant le nombre de pions au Nord Est et au Sud Ouest
    i = lig;
    j = col;
    cpt = 0;
    // on regarde au Nord Est
    while (j<NB_COLONNES && i>=0 && laGrille[i][j]==lePion){
        cpt++;
        i--;
        j++;
    }
    i = lig+1;
    j = col-1;
    // on regarde au Sud Ouest
    while (i<NB_LIGNES && j<NB_COLONNES && laGrille[i][j]==lePion){
        cpt++;
        i++;
        j--;
    }
    if (cpt>=4 ){
        return true;
    }
    return false;
}

void finDePartie(char vainqueur){
    if (vainqueur != INCONNU){
        printf("Joueur %c vainqueur\n", vainqueur);
    } else {
        printf("MATCH NUL");
    }
}
