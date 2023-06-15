#include <time.h>
#include <stdlib.h>
#include <stdio.h>

const int BORNE = 3;

int jeu(char act1, char act2){
    char res;
    if(act1 == 'P' && act2=='C'){
        return res = 'G';
    }
    if(act1 == 'C' && act2=='F'){
        return res = 'G';
    }
    if(act1 == 'F' && act2=='P'){
        return res = 'G';
    }
    if(act1 == 'P' && act2=='F'){
        return res = 'P';
    }
    if(act1 == 'C' && act2=='P'){
        return res = 'P';
    }
    if(act1 == 'F' && act2=='C'){
        return res = 'P';
    }
    if(act1 == 'P' && act2=='P'){
        return res = 'N';
    }
    if(act1 == 'C' && act2=='C'){
        return res = 'N';
    }
    if(act1 == 'F' && act2=='F'){
        return res = 'N';
    }
}

int ordi(int BORNE){
    int res;
    srand(time(NULL));
    res = rand() % BORNE;
    if (res == 0){
        return 'P';
    }
    else if(res == 1){
        return 'F';
    }
    else{
        return 'C';
    }
}

int jouer(){
    int score_h, score_o;
    score_h = 0;
    score_o = 0;
    char act_h, act_o, entre, res;
    while (score_h < 3 && score_o < 3){
        printf("Quelle action voulez vous faire : ");
        scanf("%c%c", &act_h, &entre);
        while(act_h != 'P' && act_h != 'F' && act_h != 'C'){
            printf("Recommenssez : ");
            scanf("%c%c", &act_h, &entre);            
        }
        act_o = ordi(BORNE);
        res = jeu(act_h, act_o);
        if(res == 'G'){
            score_h++;
            printf("Gagné %d | %d\n", score_h, score_o);
        }
        else if(res == 'P'){
            score_o++;
            printf("Perdu %d | %d\n", score_h, score_o);
        }
        else{
            printf("Nul %d | %d\n", score_h, score_o);
        }
    }
    if (score_h == 3){
        return 'H';
    }
    else{
        return 'O';
    }
}

int main(){
    char gagnant;
    gagnant = jouer();
    if(gagnant == 'H'){
        printf("le joueur humain a gagné\n");
    }
    else{
        printf("l'ordinateur a gagné\n");
    }
}