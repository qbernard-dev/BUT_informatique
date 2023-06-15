#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define N 10
typedef int tabEntiers[N] ;

int recherche_dicho_iteratif(int x, tabEntiers t){
    int milieu, res, debut, fin;
    bool trouve;
    debut = 0;
    fin = N-1;
    milieu = (debut+fin)/2;
    trouve = false;
    while ((trouve == false) && (debut <= fin)){
        if(t[milieu] == x){
            trouve = true;
            res = milieu;
            return res;
        }
        else if(t[milieu] < x){
            debut = milieu+1;
            milieu = (debut+fin)/2;
        }
        else{
            fin = milieu-1;
            milieu = (debut+fin)/2;
        }
    }
    if(trouve == false){
        res = -1;
        return res;
    }
}


int recherche_dicho_recursif(int x,tabEntiers t,int debut,int fin){
    int res, milieu;
    milieu = (debut+fin)/2;
    if(debut <= fin){
        if(t[milieu] == x){
            res = milieu;
            return res;
        }
        else if(t[milieu] < x){
           res = recherche_dicho_recursif(x, t, milieu+1, fin);
        }
        else{
            res = recherche_dicho_recursif(x, t, debut, milieu-1);
        }
    }
    else{
        res = -1;
        return res;
    }
    return res;
}

int main(){
    tabEntiers leTabloTrie = {13, 24, 35, 42, 53, 68, 77, 83, 88, 91} ;
    int val, res;
    printf("quelle valeur voulez-vous chercher : ");
    scanf("%d", &val);
    res = recherche_dicho_iteratif(val, leTabloTrie);
    printf("%d",res);
    res = recherche_dicho_recursif(val, leTabloTrie,0,9);
    printf("%d",res);
}