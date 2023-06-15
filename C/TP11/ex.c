#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

const char FIN[2] = "*";

#define MAX 100


typedef char t_chaine50[51] ;
typedef char t_chaine10[11] ;
typedef struct{
    t_chaine50 c_nom; // nom de l’abonné
    t_chaine10 c_num; // numéro de cet abonné
    int c_duree; // durée pour laquelle il est abonné
} t_abonne ;
typedef t_abonne t_tabAbo[MAX] ;

void lister(char nomFic[]) {
    FILE * f;
    t_abonne a;
    f = fopen(nomFic,"rb");
    fread(&a, sizeof(a),1,f);
    while(feof(f) == false){
        printf("nom : %s\nnum : %s\ndurée : %d\n",a.c_nom, a.c_num, a.c_duree);
        fread(&a, sizeof(a),1,f);
    }
    fclose(f);
}

void ajout(char nomFic[]){
    FILE * f;
    t_abonne a;
    f = fopen(nomFic,"ab");
    printf("Nom : ");
    scanf("%s", a.c_nom);
    printf("Num : ");
    scanf("%s", a.c_num);
    printf("Durée : ");
    scanf("%d", &a.c_duree);
    fread(&a, sizeof(a), 1, f);
    fwrite(&a, sizeof(a), 1, f);
    fclose(f);
}

void crea(char nomFic[]){
    FILE * f;
    t_abonne a;
    f = fopen(nomFic,"wb");
    printf("Nom : ");
    scanf("%s", a.c_nom);
    while(strcmp(a.c_nom, FIN) != 0){
        printf("Num : ");
        scanf("%s", a.c_num);
        printf("Durée : ");
        scanf("%d", &a.c_duree);
        fread(&a, sizeof(a), 1, f);
        fwrite(&a, sizeof(a), 1, f);
        printf("Nom : ");
        scanf("%s", a.c_nom);
    }
    fclose(f);
}

int copierFichierDansTableau(t_chaine50 nomFichier, t_tabAbo t){
    int compt;
    compt = 0;
    FILE * f;
    t_abonne a;
    f = fopen(nomFichier,"rb");
    fread(&a, sizeof(a),1,f);
    while(feof(f) == false && compt < MAX){
        strcpy(t->c_nom, a.c_nom);
        strcpy(t->c_num, a.c_num);
        t->c_duree = a.c_duree;
        compt++;
    }
    fclose(f);
    return compt;   
}

void maintientTrie(t_tabAbo t, int n){
    char tmp[21];
    int j, i;
    i = 1;
    j = n;
    for(i = 1; i < n; i++){  
       while(j >= 1 && strcmp(t[j].c_nom, t[j-1].c_nom) < 0){
            strcpy(tmp, t[j].c_nom);
            strcpy(t[j].c_nom, t[j-1].c_nom);
            strcpy(t[j-1].c_nom, tmp);
            j--;
        }
    }
}

void copierTableauDansFichier(char nomFic[], t_tabAbo t, int nb){
    FILE * f;
    t_abonne a;
    f = fopen(nomFic,"wb");
    for (int i =0; i < nb;i++){
        a = t[i];
    }
    fclose(f);
}

int main(){
    int ope, compt;
    t_tabAbo t;
    printf("1 : création fichier, 2 : lister fichier, 3 : ajoute, 4 : trie ");
    scanf("%d", &ope);
    switch (ope){
        case 1:
            crea("ABONNES.DATA");
            lister("ABONNES.DATA");
            break;
        case 2:
            lister("ABONNES.DATA");
            break;
        case 3:
            ajout("ABONNES.DATA");
            break;
        case 4:
            compt = copierFichierDansTableau("ABONNES.DATA", t);
            maintientTrie(t,compt);
            copierTableauDansFichier("ABONNES.DATA", t, compt);
            break;
        default:
            printf("il faut savoir lire");
            break;
    }
}