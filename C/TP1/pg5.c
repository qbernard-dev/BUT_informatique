/**
* @brief Recette de far breton pour 8 personnes
*/
#include <stdio.h>
#include <stdlib.h>
int main(){
	// variables contenant les quantités
	float pruneaux, farine, sucre, lait;
	int oeufs;
	int nbpers;
	printf("Pour combien de personnes ? :");
	scanf("%d", &nbpers);
	// initialisation des quantités
	pruneaux = (250.0*nbpers)/8;
	farine = (200.0*nbpers)/8;
	sucre = (150.0*nbpers)/8;
	oeufs = (4*nbpers)/8;
	lait = (0.75*nbpers)/8;
	// affichage des quantités
	printf("Pour préparer un Far Breton pour %d personnes, il faut :\n", nbpers);
	printf(" %5.1f grammes de pruneaux\n", pruneaux);
	printf(" %5.1f grammes de farine\n", farine);
	printf(" %5.1f grammes de sucre\n", sucre);
	printf(" %2d oeufs\n", oeufs);
	printf(" %5.1f litre(s) de lait", lait);
	return EXIT_SUCCESS;
}
