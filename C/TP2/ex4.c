#include <stdio.h>
#include <stdlib.h>
const int AENFANT = 7;
const int AADULTE = 12;
const int BENFANT = 8;
const int BADULTE = 14;
const int CENFANT = 9;
const int CADULTE = 16;
const int DENFANT = 10;
const int DADULTE = 18;
int main(){
    int enfants, adultes, res;
    char periode;
    char entre;
    printf("Quelle est le nombre d'enfants : ");
	scanf("%d", &enfants);
    printf("Quelle est le nombre d'adultes : ");
	scanf("%d", &adultes);
    printf("Quelle la période : ");
	scanf("%c%c", &entre, &periode);
    switch (periode){
        case 'A':
            res = enfants*AENFANT + adultes*AADULTE;
            printf("Le prix total est de : %d euros", res);
            break;
        case 'B':
            res = enfants*BENFANT + adultes*BADULTE;
            printf("Le prix total est de : %d euros", res);
            break;
        case 'C':
            res = enfants*CENFANT + adultes*CADULTE;
            printf("Le prix total est de : %d euros", res);
            break;  
        case 'D':
            res = enfants*DENFANT + adultes*DADULTE;
            printf("Le prix total est de : %d euros", res);
            break;
        default :
            printf("ERREUR");
    }
    	return EXIT_SUCCESS;
}