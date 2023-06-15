#include <stdio.h>
#include <stdlib.h>

float somme(float v1, float v2){
    float res;
    res = 0;
    res = v1 + v2;
    return res;
}

float soustraction(float v1, float v2){
    float res;
    res = 0;
    res = v1 - v2;
    return res;
}

float multiplication(float v1, float v2){
    float res;
    res = 0;
    res = v1 * v2;
    return res;
}

float division(float v1, float v2){
    float res;
    res = 0;
    if (v2 == 0){
        return printf("On ne peux pas diviser par 0");
    }
    else{
        res = v1 / v2;
        return res;        
    }
}

void test(){
    printf("valeur attendue : %.2f valeur obtenue : %.2f\n",24.4,soustraction(somme(4.2,multiplication(5.3,somme(division(somme(4.5,1.3),2.0),1.1))),1.0));
}

int main(){
    test();
}