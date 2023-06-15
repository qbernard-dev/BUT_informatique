#include <time.h>
#include <stdlib.h>
#include <stdio.h>

const int FIN = 10;

int generer(int borne){
    srand(time(NULL));
    return rand() % borne;
}

int comparer(int val, int vsecret){
    int res;
    if(val == vsecret){
        res = 0;
    }
    else if (val > vsecret){
        res = 1;
    }
    else{
        res = -1;
    }
    return res;
}

int jeu(int vsecret){
    int nb_essais, res, val;
    nb_essais = 0;
    res = comparer(val, vsecret);
    while (res != 1){
        printf("Quelle valeur : \n");
        scanf("%d", &val);
        if(comparer(val, vsecret) == 0){
            printf("égal\n");
            res = 1;
        }
        else if (comparer(val, vsecret) == 1){
            printf("nombre inférieur\n");
        }
        else{
            printf("nombre supérieur\n");
        }
        nb_essais++;        
    }
    return nb_essais;
}

void afficherResultat(int nb_essais){
    if(nb_essais <= FIN){
        printf("Gagné en %d coups\n", nb_essais);
    }
    else {
        printf("perdu\n");
    }
}

int main(){
    int vsecret, borne, nb_essais;
    printf("Quelle valeur pour la borne : \n");
    scanf("%d", &borne);
    vsecret = generer(borne);

printf("%d", vsecret);

    nb_essais = jeu(vsecret);
    afficherResultat(nb_essais);
}