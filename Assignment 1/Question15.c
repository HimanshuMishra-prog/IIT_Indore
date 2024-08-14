/*triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
1, 3, 6, 10, 15, 21, 28, 36, 45, 55, . . .
Let us list the factors of the first seven triangle numbers:
1 : 1
3 : 1, 3
6 : 1, 2, 3, 6
10 : 1, 2, 5, 10
15 : 1, 3, 5, 15
21 : 1, 3, 7, 21
28 : 1, 2, 4, 7, 14, 28
We can see that 28 is the first triangle number to have over five proper divisors.
What is the value of the first triangle number to have over five hundred divisors?*/

#include <stdio.h>
#include <math.h>
#include <stdbool.h>

int countDivisors(int num) {
    int count = 0;
    int sq = (int)sqrt(num);
    
    for (int i = 1; i <= sq; i++) {
        if (num % i == 0) {
            if (i == num / i) {
                count++;
            } else {
                count += 2;
            }
        }
    } 
    return count;
}

int findTriangleNumber(int divisor_count) {
    int n = 1;
    int sum = 1;
    
    while (true) {
        int divisors = countDivisors(sum);
        if (divisors > divisor_count) {
            return sum;
        }
        
        n++;
        sum += n;
    }
}

int main() {
    int divisor_count = 500;
    int triangle_number = findTriangleNumber(divisor_count);
    
    printf("The first triangle number with more than %d divisors is %d.\n", divisor_count, triangle_number);
    
    return 0;
}
