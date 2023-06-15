/*
BERNARD Quentin 1B2
le programme est un menu qui permet à l'utilisiteur d'utiliser différente fonction sur un fichier donnée par l'utilisateur
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

typedef char chaine5[6];
typedef struct {
    chaine5 code;
    int annee;
    int dept;
    float production;
} eolienne;

#define MAX 100
const eolienne INIT = {"",0,0,0.0};
typedef eolienne tabEoliennes[MAX];

void initialiser(tabEoliennes t){
    int i;
    for (i=0; i < MAX; i++){
        t[i] = INIT;
    }
}

void lireFichier (tabEoliennes t, char nomFic[], int *nb){
    printf("nb : %d", nb);
    int i = 0;
    FILE * f;
    tabEoliennes a;
    f = fopen(nomFic,"rb");
    fread(&a, sizeof(a),1,f);
    while(feof(f) == false && *nb < MAX){
        strcpy(t->code, a->code);
        t->annee = a->annee;
        t->dept = a->dept;
        t->production = a->production;
        *nb = *nb + 1;
    }
}

void afficheListe(tabEoliennes t, int nb){
    int i = 0;
    while (i < nb){
        printf("\nCode : %s  Année : %d Dept : %d Prod : %.1f",t[i].code, t[i].annee, t[i].dept, t[i].production);
        i++;
    }
}

int chercher(tabEoliennes t, int nb, chaine5 code){
    int i,trouve;
    i = 0;
    trouve = -1;
    while(i < nb && trouve == -1){
        if(strcmp(t[i].code, code) == 0){
            trouve = i;
        }
        i++;
    }
    return trouve;
}

void production(tabEoliennes t, int nb, int dep, float *prod){
    int i;
    for(i=0; i < nb; i++){
        if(t[i].dept == dep){
            *prod = *prod + t[i].production;
        }
    }
}

bool supprimer(tabEoliennes t, int *nb, chaine5 code){
    bool present = false;
    int i = 0;
    int j;
    while(present == false && i < *nb){
        if(strcmp(t[i].code, code) == 0){
            present = true;
            for (j=i; j <= *nb; j++){
                t[j] = t[j+1];
            }
            *nb = *nb -1;
        }
        i++;
    }
    return present;
}

void sauvegarder(tabEoliennes t, int nb, char nomFic[]){
    FILE * f;
    tabEoliennes a;
    f = fopen(nomFic,"wb");
    for (int i =0; i < nb;i++){
        a[i] = t[i];
    }
    fclose(f);
}


int main(){
    int ope, compt, present, dep;
    float prod;
    compt = 0;
    char nom[20];
    char code[5];
    tabEoliennes t;
    printf("1 - lire un fichier \n2 - afficher les eoliennes \n3 - chercher une eolienne \n4 - production d'un departement \n5 - supprimer une eolienne \n6 - sauvergarder les donnes \n0 - quitter");
    scanf("%d", &ope);
    while(ope != 0){
        printf("Donnez le nom du fichier : ");
        scanf("%s", &nom);
        switch (ope){
            case 1:
                lireFichier(t, nom, &compt);
                break;
            case 2:
                afficheListe(t, compt);
                break;
            case 3:
                printf("\nQuelle est le code : ");
                scanf("%s", code);
                present = chercher(t, compt, code);
                if(present != -1){
                    printf("\nL'éolienne existe est voici son indice : %d", present);
                }
                else{
                    printf("\nL'éolienne n'existe pas");
                }
                break;
            case 4:
                printf("\nQuelle départment : ");
                scanf("%d", &dep);
                production(t, compt, dep, &prod);
                break;
            case 5:
                printf("\nQuelle est le code : ");
                scanf("%s", code);
                present = supprimer(t, &compt, code);
                if(present == 1){
                    printf("\nL'éolienne existe et est supprimé");
                }
                else{
                    printf("\nL'éolienne n'existe pas");
                }
                break;
            case 6:
                sauvegarder(t, compt, nom);
            default:
                printf("le numéro n'est pas valide");
                break;
        }
        printf("1 - lire un fichier \n2 - afficher les eoliennes \n3 - chercher une eolienne \n4 - production d'un departement \n5 - supprimer une eolienne \n6 - sauvergarder les donnes \n0 - quitter");
        scanf("%d", &ope);
    }
}