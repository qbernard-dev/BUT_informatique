#include <stdio.h>
#include <stdlib.h>
#include <string.h>

const float TAUX = 0.80;
const char FIN[2] = "*" ;

void traiterUnEMployer(char nom[], float salaire, float *tot_s){
    float salaire_net;
    salaire_net = salaire * TAUX;
    *tot_s = *tot_s + salaire_net;
    printf("%s gagne %.2f € net par mois\n", nom, salaire_net);  
}

void afficheMoyenne(int compt, float tot_s){
    float moy;
    if (compt == 0){
        printf("la division par 0 n'héxiste pas");
    }
    else{
        moy = tot_s / (compt*1.0);
        printf("la moyenne des salaires net est de %2.f €", moy);
    }
}

int main(){
    char nom[20];
    float salaire, moy, tot_s;
    int compt;
    tot_s = 0;    
    printf("Quel est votre nom : ");
    scanf("%s",nom);
    if(strcmp(nom, FIN) == 0){
        printf("Personne souhaite connaitre son salaire net");
    }
    else{
        while(strcmp(nom, FIN) != 0){
            printf("Quelle est votre salaire brut :");
            scanf("%f", &salaire);
            if (salaire <= 0){
                printf("erreur\n");
            }
            else{
                traiterUnEMployer(nom, salaire, &tot_s);    
                printf("Quel est votre nom : ");
                scanf("%s",nom);
                compt++;
            }
        }
        afficheMoyenne(compt, tot_s);
    }
}