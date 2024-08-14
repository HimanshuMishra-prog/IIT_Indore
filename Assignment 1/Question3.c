/*3. A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding
the number itself.
For instance, 6 has divisors 1, 2 and 3 (excluding itself), and 1 + 2 + 3 = 6; so 6 is a perfect
number.
A number n is called deficient if the sum of its proper divisors is less than n and it is called
abundant if this sum exceeds n.
For instance, 12 has divisors 1, 2, 3, 4, and 6 (excluding itself), and 1 + 2 + 3 + 4 + 6 = 16; so
12 is an abundant number.
(a) Write a C program to check a given number is a perfect number/deficient/abundant.
(b) By mathematical analysis, it can be shown that all integers greater than 28123 can be
written as the sum of two abundant numbers. However, this upper limit cannot be reduced
any further by analysis, even though it is known that the greatest number that cannot be
expressed as the sum of two abundant numbers is less than this limit. Find the sum of all
the positive integers which cannot be written as the sum of two abundant numbers.*/

#include <stdio.h>
#include <math.h>

int divisorSum(int x) {
    int sum = 0;
    for (int i = 1; i*i <= x; i++) {
        if (x % i == 0) {
            sum = sum+i;
            if(x/i != i && i != 1){
                sum = sum + x/i;
            }
        }   
    }
    return sum;
}

int main() {
    int n;
    printf("Enter the value to check :");
    scanf("%d", &n);
    int sum = divisorSum(n);
    if(sum < n){
        printf("The number is deficient");
    }
    else if(sum == n){
        printf("The number is perfect");
    }
    else{
        printf("The number is abundant");
    }

    return 0;
}
