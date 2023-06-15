#include <stdio.h>
#include <stdlib.h>

int factorielle(int val){
    int i, somme;
    i=1;
    somme=1 ;
    if(val==0){
        somme = 1;
    }
    else{
        while (i<= val) {
            somme=somme*i ;
            i=i+1;
        }        
    }
    return somme;
}

void test(){
    printf("valeur attendue : %d valeur obtenue : %d\n",1,factorielle(0));
    printf("valeur attendue : %d valeur obtenue : %d\n",1,factorielle(1));
    printf("valeur attendue : %d valeur obtenue : %d\n",2,factorielle(2));
    printf("valeur attendue : %d valeur obtenue : %d\n",6,factorielle(3));
    printf("valeur attendue : %d valeur obtenue : %d\n",5040,factorielle(7));
}

int main(){
    /*
    int val, facto;
    printf("entrez la valeur : ");
    scanf("%d", &val);
    facto = factorielle(val);
    printf("le résultat est de %d\n",facto);
    */
   test();
}
