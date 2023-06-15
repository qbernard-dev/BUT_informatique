#include <stdio.h>
#include <stdlib.h>

void usage();
void calcul(int, int, char);


int main(){
    int nb1, nb2;
    char c;
    nb1 = 0;
    nb2 = 0;
    usage();
    do {
        scanf("%d %c %d", &nb1, &c, &nb2);
        calcul(nb1, nb2, c);
    } while (c != ':');
}

void usage(){
    printf("Ecrivez une suite d’operations sous la forme:\n<operande> <operateur> <operande>\nPour terminer utilisez comme operateur.\nPar exemple 0 : 0 stoppe le programme\n9 + 6\n9 - 6\n9 * 6\n9 > 6\n9 / 6\n0 : 0\n");
}

void calcul(int nb1, int nb2, char c){
    int temp;
    temp = 0;
    switch (c){
        case '*':
        temp = nb1*nb2;
            printf("%d %c %d", &nb1, &c, &nb2, "=", "%d", temp);
            break;
        case '+':
        temp = nb1+nb2;
            printf("%d %c %d", &nb1, &c, &nb2, "=", "%d", temp);
            break;
        case '-':
        temp = nb1-nb2;
            printf("%d %c %d", &nb1, &c, &nb2, "=", "%d", temp);
            break;
        case '/':
        temp = nb1/nb2;
            printf("%d %c %d", &nb1, &c, &nb2, "=", "%d", temp);
            break;
        case ':':
            printf("\nAu revoir");
            break;
        default: 
            printf("Opérateur inconnue");
            break;
    }
}