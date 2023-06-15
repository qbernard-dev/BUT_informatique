#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define N 8
typedef char mot8lettres[N] ;

void init (mot8lettres tab){
    int i;
    for(i=0; i < N; i++){
        tab[i] = '*';
    }
}

void saisir (mot8lettres tab){
    int i;
    char carac, entre;
    for(i=0; i < N; i++){
        printf("Rentrez un caractère : ");
        scanf("%c%c", &carac, &entre);
        tab[i] = carac;
    }
}

void afficheTab(mot8lettres t){
    int i;
    for(i=0; i < N; i++){
        printf("%c", t[i]);
    }
}

bool contient(mot8lettres t, char c){
    bool fin;
    int i;
    fin = false;
    for (i=0; i < N; i++){
        if(t[i] == c){
            fin = true;
            return fin;
        }
    }
    return fin;
}

int main(){
    mot8lettres tab = {};
    char carac, entre; 
    bool res;
    init(tab);
    saisir(tab);
    afficheTab(tab);
    printf("\nRentrez un caractère : ");
    scanf("%c%c", &carac, &entre);
    res = contient(tab, carac);
    if (res == false){
        printf("faux");
    }
    else{
        printf("vrai");
    }
}