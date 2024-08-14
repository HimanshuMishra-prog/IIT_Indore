/*Write a C program to calculate the total of the following series for a given x and n; where,
−1 < x ≤ 1, n > 100,
total = x −
x2
2
+
x3
3
−
x4
4
+ ... upto nth t*/

#include <stdio.h>
#include <math.h>

double calculateSeriestotal(double x, int n) {
    double total = 0.0;
    double no = 1.00;
    for (int i = 1; i <= n; i++) {
        no=no*x;
        double t = no / i;
        if (i % 2 == 0) {
            t = -t;
        }
        total += t;
    }
    return total;
}

int main() {
    double x;
    int n;
    printf("Enter the value of x ");
    scanf("%lf", &x);

    printf("Enter the value of n: ");
    scanf("%d", &n);
    double total = calculateSeriestotal(x, n);
    printf("The total of the series is: %lf\n", total);

    return 0;
}
