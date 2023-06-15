#include <stdio.h>
#include <stdlib.h>

void division(int a, int b, int *reste, int *quotient){
    if (b == 0){
        print ("la division par 0 n'hésite pas")
    }
    else{
        *reste = a / b;
        *quotient = a % b;
    }

}

int main(){
    int a, b;
    int reste, quotient;
    printf("valeure de a : ");
    scanf("%d", &a);
    printf("valeure de b : ");
    scanf("%d", &b);
    division(a, b, &reste, &quotient);
    printf("le reste = %d et le quotient = %d\n", reste, quotient);
}