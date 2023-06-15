#include <stdio.h>
#include <stdlib.h>

void ligneTiret(int);
void ligneCourante(int);
void rectangle(int, int);

int main(){
    int t, c;
    printf("Le nombre de ligneTirets : ");
    scanf("%d",&t);
    printf("Le nombre de ligneCourante : ");
    scanf("%d",&c);
    rectangle(t, c);
    return EXIT_SUCCESS;
}

void ligneTiret(int t){
    int i;
    for (i = 0; i < t; i++){
        printf("-");
    }
}

void ligneCourante(int c){
    printf("I");
}

void rectangle(int n, int larg){
    int i;
    int x;
    ligneTiret(n);
    printf("\n");
    for (i=1; i <= larg; i++){
        ligneCourante(larg);
        for (x = 0; x < n-2; x++){
            printf(" ");
        }
        ligneCourante(larg);
        printf("\n");
    }    
    ligneTiret(n);
}