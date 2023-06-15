#include <stdio.h>
#include <stdlib.h>
int main (){
    int i, n , somme;
    printf(" entrez un entier naturel : \n") ;
    scanf("%d",&n) ;
    i=1;
    somme=1 ;
    if(n==0){
        printf("résultat : %d\n",somme) ;
    }
    while ( i<= n ) {
        somme=somme*i ;
        i=i+1;
    }
    printf("résultat : %d\n",somme) ;
    return EXIT_SUCCESS ;
}