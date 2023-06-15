#include <stdio.h>
#include <stdlib.h>

void ligne(int);

int main(){
    int m;
    printf("Entrez la ligne que vous souhaitez : ");
    scanf("%d", &m);
    ligne(m);
    return EXIT_SUCCESS;
}

void ligne(int m){
    int i;
    for (i = 0; i < 10; i++){
        printf("%4d", i*m);
    }
}