/*1. Given two positive integers, write a C program to find out whether two numbers are co-prime.
Take numbers from the user externally.*/
#include <stdio.h>
int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

int main() {
    int a,b;
    printf("Enter the integer: ");
    scanf("%d", &a);
    printf("Enter the next integer: ");
    scanf("%d", &b);
    
    if (gcd(a,b)==1) {
        printf("%d and %d are co-prime.\n", a, b);
    } else {
        printf("%d and %d are not co-prime.\n", a, b);
    }

    return 0;
}
