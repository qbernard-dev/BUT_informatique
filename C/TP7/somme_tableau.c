#include <stdio.h>
#include <stdlib.h>

#define N 5
typedef int untableau[N];

int somme (untableau t){
    int somme, i;
    somme = 0;
    for(i=0; i < N; i++){
        somme = somme + t[i];
    }
    return somme;
}

int main(){
    int res;
    untableau t = {5,8,2,3,4};
    res = somme(t);
    printf("%d", res);
}