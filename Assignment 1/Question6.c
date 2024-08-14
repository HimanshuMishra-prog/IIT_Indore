/*Write a C program to obtain the values of permutations nPr and combinations nCr, when n
and r are given. (n and r denote their usual meaning).*/

#include <stdio.h>

long long nCr(int n, int r) {
    if (r > n) return 0;
    if (r > n - r) r = n - r;

    long long result = 1;
    for (int i = 0; i < r; i++) {
        result = result * (n - i) / (i + 1);
    }
    return result;
}
long long nPr(int n, int r) {
    if (r > n) return 0;

    long long result = 1;
    for (int i = 0; i < r; i++) {
        result *= (n - i);
    }
    return result;
}

int main() {
    int n, r;
    printf("Enter values for n and r:\n");
    scanf("%d %d", &n, &r);
    printf("nCr (Combinations) of %d and %d is: %lld\n", n, r, nCr(n, r));
    printf("nPr (Permutations) of %d and %d is: %lld\n", n, r, nPr(n, r));

    return 0;
}
