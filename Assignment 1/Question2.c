/*A number is called an Armstrong number if the sum of the cubes of the digits of the number
is equal to the number. Write a C program that asks the user to enter a number and returns
whether it is an Armstrong number.*/

#include <stdio.h>
#include <math.h>

int isArmstrongNumber(int number) {
    int originalNumber = number;
    int sum = 0;
    while (number > 0) {
        int digit = number % 10;
        sum += pow(digit, 3); 
        number /= 10;
    }
    if(sum == originalNumber){return 1;}
    else {return 0;}
}

int main() {
    int number;
    printf("Enter your number to check: ");
    scanf("%d", &number);

    if (isArmstrongNumber(number)) {
        printf("%d is Armstrong number.\n", number);
    } else {
        printf("%d is not Armstrong number.\n", number);
    }

    return 0;
}

