#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define N 10
typedef int tabEntiers[N] ;

int recherche_sequentielle (int x, tabEntiers t ){
    int i, res;
    bool fin;
    fin = false;
    /*
    for (i = 0; i < N+1; i++){
        if(x == t[i]){
            res = i;
            return res;
        }
        else{
            res = -1;
        }
    }
    return res;
    */
   i = 0;
    res = -1;
   while((fin == false) && (i < N)){
        if(t[i] == x){
            res = i;
            fin = true;
        }
        else{
            i = i + 1;
        }
    }
    return res;
}

int main(){
    tabEntiers leTablo = {23, 54, 65, 12, 43, 78, 68, 93, 18, 31} ;
    int val, res;
    printf("quelle valeur voulez-vous chercher : ");
    scanf("%d", &val);
    res = recherche_sequentielle(val, leTablo);
    printf("%d", res);
}