/**
* @brief quelques affectations
*/
#include <stdio.h>
#include <stdlib.h>
const float PI=3.14159; // déclaration et affectation d’une constante de type réel
int main(){
	int un ; // déclaration d’une variable de type entier
	float x; // déclaration d’une variable de type réel
	un = 12;
	x = 8.42;
	printf("voici un : %d et x : %f. Ce sont deux variables.\n", un,x); // quelle différence avec la suite ?
	printf("voici un : %d et x : %f et PI : %.3f. Ce sont trois variables.\n", un,x,PI);
	return EXIT_SUCCESS;
}
