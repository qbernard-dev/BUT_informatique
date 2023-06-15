/*
BERNARD Quentin 1B2
le programme fait le calcul de la suite A :
    elle prend en paramètre une valeur n
*/

#include <stdio.h>
#include <stdlib.h>

int A(int n){
    int res;
    if (n == 0){
        res = 1;
        return res;
    }
    else{
        res = 4*A(n-1)+3;
    }
}

void testerA(int n, int res_attendu){
    int res;
    res = A(n);
    printf("n : %d    résultat attendu : %d    résultat obtenu : %d\n", n, res_attendu, res);
}

int main(){
    testerA(0,1);
    testerA(1,7);
    testerA(2,31);
    testerA(3,127);
}
