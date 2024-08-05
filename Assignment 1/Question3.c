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

// #include <stdio.h>
// #include <math.h>

// double calculateSeriesSum(double x, int n) {
//     double sum = 0.0;
//     double no=1.0;
//     for (int i = 1; i <= n; i++) {
//         no=no*x;
//         double term = no / i;
//         if (i % 2 == 0) {
//             term = -term;
//         }
//         sum += term;
//     }
//     return sum;
// }

// int main() {
//     double x;
//     int n;
//     printf("Enter the value of x (-1 < x ≤ 1): ");
//     scanf("%lf", &x);
//     if (x <= -1 || x > 1) {
//         printf("Error: x must be in the range (-1, 1].\n");
//         return 1;
//     }

//     printf("Enter the value of n (n > 100): ");
//     scanf("%d", &n);
//     if (n <= 100) {
//         printf("Error: n must be greater than 100.\n");
//         return 1;
//     }
//     double sum = calculateSeriesSum(x, n);
//     printf("The sum of the series is: %lf\n", sum);

//     return 0;
// }
