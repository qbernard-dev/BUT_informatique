#include <stdio.h>
#include <stdlib.h>

void ligneTiret(int);
void ligneCourante(int);
void rectangle(int);

int main(){
    int h;
    printf("La hauteur du triangle rectangle : ");
    scanf("%d", &h);
    rectangle(h);
    return EXIT_SUCCESS;
}

void ligneTiret(int t){
    int i;
    for (i = 0; i < t; i++){
        printf("-");
    }
}

void ligneCourante(int nl){
    int i;
    printf("I");
    for (i = 0; i < nl-1; i++){
        printf(" ");
    }
    printf("\\");
    printf("\n");
}

void rectangle(int n){
    int i;
    for (i = 1; i <= n; i++){
        ligneCourante(i);
    }
    ligneTiret(n);
    printf("\n";)
}