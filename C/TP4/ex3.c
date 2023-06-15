#include <stdio.h>
#include <stdlib.h>

void min(int, int);

int main(){
    int val1, val2;
    printf("\nEntrez la valeur 1 :");
    scanf("%d",&val1);
    printf("\nEntre la valeur 2 :");
    scanf("%d",&val2);
    min(val1,val2);
    return EXIT_SUCCESS;
}

void min(int val1, int val2){
    if(val1 < val2){
        printf("La plus petite valeur est %d ", val1);
    }
    else if(val2 < val1){
        printf("La plus petite valeur est %d ", val2);
    }
    else{
        printf("Les valeurs sont les mêmes");
    }
}