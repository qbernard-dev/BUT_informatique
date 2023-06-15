#include <stdlib.h>
#include <stdio.h>
int main()
{
	char nom[10];
	char groupe;
	printf("Nom ? ");
	scanf("%s", nom);
	printf("Groupe ? ");
	scanf("%c", &groupe);
	printf("Nom=%s\n",nom);
	printf("Groupe=%c\n",groupe);
	return EXIT_SUCCESS;
}
