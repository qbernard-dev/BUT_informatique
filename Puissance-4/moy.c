#include <stdio.h>
#include <stdlib.h>

const int FIN = -1;
const int VALMIN = 0;
const int VALMAX = 20;

int main(){
    float tot_nb,tot_s,n, moy ;
    tot_nb = 0;
    tot_s = 0;
    printf("Entrez la valeur : ");
    scanf("%f",&n);
    if(n == FIN){
        printf("Pas de moyenne");
    }
    else{
        while(n != FIN){
            if((n >= VALMIN) && (n <= VALMAX)){
                tot_nb = tot_nb+n;
                tot_s++;         
                printf("Entrez la valeur : ");
            }
            else{                    
                printf("ERREUR rentrez une nouvelle valeure : ");
                scanf("%f",&n);
                if((n >= VALMIN) && (n <= VALMAX)){
                    tot_nb = tot_nb+n;
                    tot_s++;         
                    printf("Entrez la valeur : ");
                }
                else{
                    while((n >= VALMIN) && (n <= VALMAX)){
                        printf("ERREUR rentrez une nouvelle valeure : ");
                        scanf("%f",&n);
                    }
                }

            }
            scanf("%f",&n);
        }
        moy = tot_nb/tot_s;
        printf("La moyenne est de %.2f ", moy);
    }

    return EXIT_SUCCESS;
}