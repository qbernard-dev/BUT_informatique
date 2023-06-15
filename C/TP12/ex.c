#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define MAX 10

typedef char chaine20[21];
typedef struct{
    chaine20 nomPlanete;
    int diametre;
} tPlanete;

typedef tPlanete tabPlanetes[MAX];
typedef int tabDistances[MAX][MAX];

void initDistances(tabDistances td){
    int i,j;
    for (i=0; i < MAX; i++){
        for (j=0; j < MAX; j++){
            td[i][j] = 0;
        }
    }
}

void remplirPlanetes(tabPlanetes tp, int * nbPlanetes){
    int i = 0;
    FILE * f;
    tPlanete a;
    f = fopen("Planetes.data","rb");
    fread(&a, sizeof(a),1,f);
    while(feof(f) == false && *nbPlanetes < MAX){
        tp[i] = a;
        i++;
        (*nbPlanetes)++;
        fread(&a, sizeof(a),1,f);
    }
    fclose(f);
}

void remplirDistances(tabPlanetes tp, tabDistances td, int nbPlanetes) {
    int dist,i,j;
    for (i=0;i < nbPlanetes-1; i++){
        for (j=i+1; j < nbPlanetes; j++){
            printf("\nDistance entre %s et %s : ", tp[i].nomPlanete, tp[j].nomPlanete);
            scanf("%d", &dist);
            td[i][j] = dist;
            td[j][i] = dist;
        }
    }
}

void afficherPlanetes(tabPlanetes tp, int compt){
    int i = 0;
    while (i < compt){
        printf("\nNom : %s  Diametre : %d", tp[i].nomPlanete, tp[i].diametre);
        i++;
    }
}

void afficherDistances(tabDistances td, tabPlanetes tp, int nbPlanetes){
    int i,j;
    printf("        ");
    for (i=0; i <nbPlanetes ; i++){
        printf(tp[i].nomPlanete);
        printf("       ");
    }
    for (i=0; i < nbPlanetes; i++){
        printf("\n");
        printf(tp[i].nomPlanete);
        for (j=0; j < nbPlanetes; j++){
            printf("     %d      ",td[i][j]);
        }
        
    }
}

int plusGrandeDistance(tabDistances td, int nbPlanetes){
    int i,j,max;
    max = 0;
    for (i=0; i < nbPlanetes; i++){
        for (j=0; j < nbPlanetes; j++){
            if(max < td[i][j]){
                max = td[i][j];
            }
        }
    }
    return max;
}

int recherchePlanete(tabPlanetes tp, chaine20 nom, int nbPlanetes){
    bool trouve = false;
    int i = 0;
    while(trouve == false && i < nbPlanetes){
        if (strcmp(nom,tp[i].nomPlanete) == 0){
            return 0;
        }
    }
    return -1;
}

int main(){
    tPlanete t;
    tabDistances tabd;
    tabPlanetes tabp;
    int compt = 0;
    int max_dist, existe;
    char nom[20];
    char absorbe[1];
    initDistances(tabd);
    remplirPlanetes(tabp, &compt);
    afficherPlanetes(tabp, compt);
    remplirDistances(tabp, tabd, compt);
    afficherDistances(tabd, tabp, compt);
    max_dist = plusGrandeDistance(tabd, compt);
    printf("\nLa plus grande est de %d km" , max_dist);
    printf("\nQuel planete dans le fichier : ");
    scanf("%s%c",nom,&absorbe);
    existe = recherchePlanete(tabp, nom, compt);
    if (existe == 0){
        printf("\nLa planete est dans le fichier");
    }
    else{
        printf("La planete n'est pas dans le fichier");
    }
}