#include <stdio.h>
#include <stdlib.h>

#define N 21
typedef int tableau[N] ;

const int FIN = -1;

void initTab(tableau t){
    int i;
    for(i = 0; i < N; i++){
        t[i] = 0;
    }
}

void noteTab(tableau t, int val){
    int i;
    for(i = 0; i < N; i++){
        if(i == val){
            t[i]++;
        }
    }
}

void afficheTab(tableau t){
    int i;
    for(i=0; i < N; i++){
        if(t[i] != 0){
            printf("note %d : %d\n", i, t[i]);
        }
    }
}

int main(){
    int val;
    tableau t = {};
    initTab(t);
    printf("entrez une note : ");
    scanf("%d", &val);
    while(val != FIN){
        noteTab(t, val);
        printf("entrez une note : ");
        scanf("%d", &val);
    }
    afficheTab(t);
}