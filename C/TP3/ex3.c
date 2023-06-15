#include <stdio.h>
#include <stdlib.h>
int main(){
    int tot_nb,tot_s,n,suite ;
    float moy;
    printf("Le nombre de valeur de la suite :");
    scanf("%d",&suite);
    tot_s = suite;
    if (suite == 0){
        printf("pas de  moyenne");
    }
    else{
        while(suite >= 1){
            printf("Entrez la valeur : ");
            scanf("%d",&n);
            tot_nb = tot_nb+n;
            suite = suite - 1;
    }
        moy = tot_nb/(tot_s*1.0);
    printf("La moyenne de la suite de valeur est de %.2f", moy);
    }
}