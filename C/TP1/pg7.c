#include <stdlib.h>
#include <stdio.h>
int main()
{
	char nom[10];
	char prenom[10];
	printf("Nom ? ");
	scanf("%s", nom);
	printf("Prenom ? ");
	scanf("%s", prenom);
	printf("Nom=%s\n",nom);
	printf("Prenom=%s\n",prenom);
	return EXIT_SUCCESS;
}
