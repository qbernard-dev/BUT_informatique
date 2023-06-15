#include <stdio.h>
#include <stdlib.h>

const int FIN = 0;

void suite(int vals, int *min, int*max){
    if (vals < 0){
        printf("on accepte que les chiffres postifs");
    }
    else{
        if (vals <= *min){
            *min = vals;
        }
        if (vals >= *max){
            *max = vals;
        }
    }
}

int main(){
    int vals, min, max;
    max = -1;
    printf("entrez la valeur : ");
    scanf("%d", &vals);
    min = vals;
    if (vals == 0){
        printf("la suite est vide");
    }
    else{
        while (vals != FIN){
            suite(vals, &min, &max);
            printf("entrez la valeur : ");
            scanf("%d", &vals);
        }
        printf ("min = %d et max = %d", min, max);
    }
}