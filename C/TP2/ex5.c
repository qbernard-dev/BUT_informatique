#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(){
    char ch1[20];
    char ch2[20];
    char ch3[20];
    printf("Entré la première chaine de caractère :");
    scanf("%s",ch1);
    printf("Entré la deuxième chaine de caractère :");
    scanf("%s",ch2);
    printf("Entré la troisième chaine de caractère :");
    scanf("%s",ch3);
    if (strcmp(ch1,ch2)==0){
        printf("Les deux chaines sont égaux");
    }
    else if (strcmp(ch1,ch2)>0){
        printf("La chaine de caractère 1 est supérieur à la deuxième");
    }
    else{
        printf("La chaine de caractère 2 est supérieur à la première");
    }
}