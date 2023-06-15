#include <stdio.h>
#include <stdlib.h>
const int FIN = 1;
int main(){
    int suite,max ;
    float n;
    printf("Le nombre de valeur de la suite :");
    scanf("%d",&suite);
    if(suite == 0){
        printf("Aucune valeur");
    }
    else{
        printf("Entrez la valeur : ");
        scanf("%f",&n);
        max = n;
        while(suite > FIN){
            printf("Entrez la valeur : ");
            scanf("%f",&n);
            if(max < n){
                max = n;
            }
            suite--;
        }
    printf("La plus grande valeur de la suite est %d", max);
    }
}