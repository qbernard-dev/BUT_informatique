#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 5
typedef char chaine20[21] ;
typedef chaine20 tabnoms[N] ;

void afficheTab(tabnoms t, int n){
    int i;
    for(i=0; i < n; i++){
        printf("%s\n", t[i]);
    }
}

void maintienTrie(tabnoms t, int i){
    char tmp[21];
    int j;
    j = i;
    while(j >= 1 && strcmp(t[j], t[j-1]) < 0){
        strcpy(tmp, t[j]);
        strcpy(t[j], t[j-1]);
        strcpy(t[j-1], tmp);
        j--;
    }
}

void triParInsertion ( tabnoms t, int n){
    int i;
    for(i = 1; i < n; i++){
        maintienTrie(t, i);
    }
}

int main(){
    tabnoms tNoms = {"toto","zozo","loto","momo","mimi"};
    afficheTab(tNoms, N);
    triParInsertion(tNoms, N);
    afficheTab(tNoms, N);
}