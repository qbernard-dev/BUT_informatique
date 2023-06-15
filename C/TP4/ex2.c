#include <stdio.h>
#include <stdlib.h>

const int FIN = 0;
 
void menu();

int main(){
    int action;
    menu();
    printf("\nQue voulez vous faire :");
    scanf("%d",&action);
    while(action != FIN){
        if (action == 1){
            printf("\naction 1");
        }
        else if (action == 2){
            printf("\naction 2");
        }
        else {
            printf("\nchoix errone");
        }
        menu();
        printf("\nQue voulez vous faire :");
        scanf("%d",&action);
    }
    return EXIT_SUCCESS;
}

void menu(){
    printf("\n0 pour arrêter \n1 pour l'action n°1 \n2 pour l'action n°2");
}