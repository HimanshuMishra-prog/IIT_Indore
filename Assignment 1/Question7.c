/*7. A Harshad (or Niven) number with base n is an integer that is divisible by the sum of its digits.
Example: Input: 126; Output: Harshad number.
(Reason: 1 + 2 + 6 = 9, and 126 is divisible by 9)
Write a C program that asks to take a number (with base 10) from a user and returns whether
it is a Harshad number.*/

#include <stdio.h>

int sumOfDigits(int number) {
    int sum = 0;
    while (number > 0) {
        sum += number % 10; 
        number /= 10;      
    }
    return sum;
}

int isHarshadNumber(int number) {
    int sum = sumOfDigits(number);
    return (number % sum == 0);
}

int main() {
    int number;

    printf("Enter a number: ");
    scanf("%d", &number);

    if (isHarshadNumber(number)) {
        printf("%d is a Harshad number.\n", number);
    } else {
        printf("%d is not a Harshad number.\n", number);
    }

    return 0;
}

