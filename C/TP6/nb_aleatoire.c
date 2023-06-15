#include <time.h>
#include <stdlib.h>

// truc de nombre de aléatoire

int aleaInfBorne(int borne){
    srand(time(NULL));
    return rand() % borne;
}

int main(){
    int borne, res;
    printf("entrez la borne du nombre aléatoire : ");
    scanf("%d", &borne);
    res = aleaInfBorne(borne);
    printf("le nombre aléaoire est %d\n", res);
}