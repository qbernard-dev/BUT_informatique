#include <stdio.h>
#include <stdlib.h>

#define N 10
typedef int tabEntiers[N] ;

void afficheTab(tabEntiers t){
    int i;
    for(i=0; i < N; i++){
        printf("%d\n", t[i]);
    }
}

void tri_selection_croisssant(tabEntiers t){
    int i,j, i_mini, mini, tmp;
    for (i = 0; i < N-1; i++){
        mini = t[i];
        i_mini = i;
        for(j = i+1; j < N; j++){
            if(t[j] < mini){
                mini = t[j];
                i_mini = j;
            }
        }
        tmp = t[i];
        t[i] = t[i_mini];
        t[i_mini] = tmp;

    }
}

void tri_selection_decroisssant(tabEntiers t){
    int i,j, i_max, max, tmp;
    for (i = 0; i < N-1; i++){
        max = t[i];
        i_max = i;
        for(j = i+1; j < N; j++){
            if(t[j] > max){
                max = t[j];
                i_max = j;
            }
        }
        tmp = t[i];
        t[i] = t[i_max];
        t[i_max] = tmp;
        
    }
}

int main(){
    tabEntiers tab = {4,4,4,10,11,7,3,8,8,6};
    tri_selection_croisssant(tab);
    printf("Tri par séléction par ordre croissant : \n");
    afficheTab(tab);
    tri_selection_decroisssant(tab);
    printf("\nTri par séléction par ordre decroissant : \n");
    afficheTab(tab);
}