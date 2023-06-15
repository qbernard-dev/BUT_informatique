#include <stdio.h>
#include <stdlib.h>
#include <string.h>
const float TAUX = 0.80;
const char FIN[2] = "*" ;
int main(){
    char nom[20];
    float salaire, moy, tot_s;
    int compt;
    printf("Quel est votre nom : ");
    scanf("%s",nom);
    if(strcmp(nom, FIN) == 0){
        printf("Personne souhaite connaitre son salaire net");
    }
    else{
        printf("Quel est votre salaire : ");
        scanf("%f",&salaire);
        tot_s = salaire*TAUX;
        compt = 1;
        printf("Quel est votre nom : ");
        scanf("%s",nom);
        while(strcmp(nom, FIN) != 0){
            printf("Quel est votre salaire : ");
            scanf("%f",&salaire);
            tot_s = tot_s + (salaire*TAUX);
            compt++;
            printf("Quel est votre nom : ");
            scanf("%s",nom);
        }
    moy = tot_s/compt;
    printf("La moyenne des salaires net est de %.2f €",moy);
    }
}