#include <stdio.h>
#include <stdlib.h>
const int FIN = -1;
int main(){
    int tot_nb,tot_s,n ;
    float moy;
    while(n != FIN){
        printf("Entrez la valeur : ");
        scanf("%d",&n);
        if(n != FIN){
        tot_nb = tot_nb+n;
        tot_s++;
        }
    }
    moy = tot_nb/tot_s;
    printf("La moyenne de la suite de valeur est de %f ", moy);
}