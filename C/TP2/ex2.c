#include <stdio.h>
#include <stdlib.h>
const float TVA = 1.20;
const int LOCCOMPTEUR = 15;
const int KWHINFERIEUR = 100;
const int KWHMOYEN = 50;
const int KWHSUPERIEUR = 150;
const float PRIXKWHINFERIEUR = 0.10;
const float PRIXKWHMOYEN = 0.15;
const float PRIXKWHSUPERIEUR = 0.20;
int main(){
    float kwh;
    float res_kwh;
    printf("Combien de kWh : ");
	scanf("%f", &kwh);
    if (kwh <= KWHINFERIEUR){
        res_kwh = (PRIXKWHINFERIEUR*kwh + LOCCOMPTEUR)*TVA;
        printf("Votre facture d'électricité vous coûtes : %0.2f euros",res_kwh);
    }
    else if (kwh <= KWHMOYEN){
        res_kwh = (KWHINFERIEUR*PRIXKWHINFERIEUR + (kwh-KWHINFERIEUR)*PRIXKWHMOYEN + LOCCOMPTEUR)*TVA;
        printf("Votre facture d'électricité vous coûtes : %0.2f euros",res_kwh);
    }
    else{
        res_kwh = (KWHINFERIEUR*PRIXKWHINFERIEUR + KWHMOYEN*PRIXKWHMOYEN + (kwh-KWHSUPERIEUR)*PRIXKWHSUPERIEUR + LOCCOMPTEUR)*TVA;
        printf("Votre facture d'électricité vous coûtes : %0.2f euros",res_kwh);
    }
	return EXIT_SUCCESS;
}
	
	
