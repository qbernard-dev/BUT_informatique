#include <stdio.h>
#include <stdlib.h>
const int MOYENGENERAL = 10;
const int MOYENUE = 8;
int main(){
    float moyenne_g, moyenne_ue1, moyenne_ue2 ;
    printf("Quelle votre moyenne de l'UE1 : ");
	scanf("%f", &moyenne_ue1);
    printf("Quelle votre moyenne de l'UE2 : ");
	scanf("%f", &moyenne_ue2);
    moyenne_g = (moyenne_ue1 + moyenne_ue2) / 2;
    if (moyenne_g < MOYENGENERAL){
        printf("Jury souverain");
    }
    else if (moyenne_g >= MOYENGENERAL && (moyenne_ue1 < MOYENUE| moyenne_ue2 < MOYENUE)){
        printf("Redoublement");
    }
    else{
        printf("Semestre Validé");
    }
	return EXIT_SUCCESS;
}
