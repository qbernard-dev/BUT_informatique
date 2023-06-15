#include <stdio.h>
#include <stdlib.h>

void ligne(int);

int main(){
    int m;
    for (m = 0; m < 10; m++){
        ligne(m);
    }
    return EXIT_SUCCESS;
}

void ligne(int m){
    int i;
    for (i = 0; i < m+1; i++){
        printf("%4d", i*m);
    }
    printf("\n");
}