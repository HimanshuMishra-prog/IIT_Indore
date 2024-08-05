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

int isCoprime(int a, int b) {
    return gcd(a, b) == 1;
}

int main() {
    int num1, num2;
    printf("Enter the integer: ");
    scanf("%d", &num1);
    printf("Enter the next integer: ");
    scanf("%d", &num2);
    
    if (isCoprime(num1, num2)) {
        printf("%d and %d are co-prime.\n", num1, num2);
    } else {
        printf("%d and %d are not co-prime.\n", num1, num2);
    }

    return 0;
}
