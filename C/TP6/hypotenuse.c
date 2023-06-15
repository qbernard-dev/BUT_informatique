#include <stdio.h>
#include <stdlib.h>
#include <math.h>

float fcalcul (int v1, int v2){
    float hypotenuse;
    hypotenuse = 0;
    float temp;
    temp = 0;
    if(v1 == 0 && v2 ==0){
        return hypotenuse;
    }
    else if(v1 < 0 || v2 < 0){
        return printf("erreur");
    }
    else{
        temp = pow(v1,2) + pow(v2,2); 
        hypotenuse = sqrtf(temp);   
    }
    return hypotenuse;
}

void test(){
    printf("valeur attendue : %.3f valeur obtenue : %.3f\n",5.0,fcalcul(3,4));
    printf("valeur attendue : %.3f valeur obtenue : %.3f\n",1.414,fcalcul(1,1));
    printf("valeur attendue : %.3f valeur obtenue : %.3f\n",0.0,fcalcul(0,0));
    printf("valeur attendue : %.3f valeur obtenue : %.3f\n",3.606,fcalcul(2,3));
    printf("valeur attendue : %.3f valeur obtenue : %.3f\n",10.630,fcalcul(7,8));
}

int main(){
    /*
    float v1, v2, hypotenuse;
    printf("Entrez la valeur de v1 : ");
    scanf("%f", &v1);
    printf("Entrez la valeur de v2 : ");
    scanf("%f", &v2);
    hypotenuse = fcalcul(v1, v2);
    printf("le résultat est de %.2f",hypotenuse);
    */
   test();
}
