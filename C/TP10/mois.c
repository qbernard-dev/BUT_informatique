#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NM 12

typedef char t_chaine9[10];
typedef struct{
    t_chaine9 c_nom;
    int c_nbJours;
} t_mois;

typedef t_mois t_tabMois[NM];
const t_tabMois tMois= { {"janvier",31},
                         {"fevrier",28},
                         {"mars",31},
                         {"avril",30},
                         {"mai",30},
                         {"juin",30},
                         {"juillet",30},
                         {"aout",30},
                         {"septembre",30},
                         {"octobre",30},
                         {"novembre",30},
                         {"decembre", 31}};

void affiche(){
    int i;
    for (i=0; i < NM; i++){
        if(tMois[i].c_nbJours == 31){
            printf("%s\n", tMois[i].c_nom);
        }
    }
}


int nombreJours(t_chaine9 nomMois){
    int i, res;
    res = -1;
    i = 0;
    while(res == -1 && i < NM){
        if(strcmp(nomMois, tMois[i].c_nom) == 0){
            res = tMois[i].c_nbJours;
        }
        i++;
    }
    return res;
}


int main(){
    int res;
    t_chaine9 moi;
    printf("Entrez le nom d'un mois : ");
    scanf("%s", moi);
    res = nombreJours(moi);
    if (res == -1){
        printf("ya pas ");
    }
    else{
        printf("\n%d", res);
    }
}