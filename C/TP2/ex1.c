#include <stdio.h>
#include <stdlib.h>
const float COUTKMESSENCE = 1.2;
const int COUTJOURNEEESSENCE = 10;
const float COUTKMDIESEL = 1.0;
const int COUTJOURNEEDIESEL = 15;
int main(){
	int jour;
	float km, res_essence, res_diesel;
	printf("Combien de jours : ");
	scanf("%d", &jour);
	printf("Combien de KM : ");
	scanf("%f", &km);
	res_essence = jour*COUTJOURNEEESSENCE + km*COUTKMESSENCE;
	res_diesel = jour*COUTJOURNEEDIESEL + km*COUTKMDIESEL;
	if (res_essence == res_diesel){
		printf("Les prix sont égaux");
	}else if (res_essence < res_diesel){
		printf("Le véhicule essence est moins coûteux");
	}else {
		printf("Le véhicule diesel est moins coûteux");
	}
	return EXIT_SUCCESS;
}
	
	
