/*Amicable numbers are found in pairs. A given pair of numbers is Amicable if the sum of the
proper divisors (not including itself) of one number is equal to the other number, and vice-versa.
For example 220 & 284 are amicable numbers. First, we find the proper divisors of 220.
220: 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110;
1+ 2 + 4 + 5 + 10 + 11 + 20 + 22 + 44 + 55 + 110 = 284;
Now, 284: 1, 2, 4, 71, 142;
1 + 2 + 4 + 71 + 142 = 220
Write a C program to check whether the input pair of numbers is amicable.*/

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

int main(){
    int n1, n2, sum1 =0 , sum2 = 0;
    printf("Enter the first value to check :");
    scanf("%d", &n1);
    printf("Enter the second value to check :");
    scanf("%d", &n2);
    sum1 = divisorSum(n1);
    sum2 = divisorSum(n2);
    if(sum1 == n2 && sum2 == n1){
        printf("The numbers are amicable");
    }
    else {
        printf("The numbers are not amicable");
    }

}
