/*A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation
of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically,
we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
012 021 102 120 201 210
What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?*/

#include <stdio.h>

int factorial(int n) {
    int fact = 1;
    for (int i = 1; i <= n; i++) {
        fact *= i;
    }
    return fact;
}

void findPermutation(int n, int digits[], int len, char result[]) {
    int fact;
    int i, j;
    n--;
    for (i = 0; i < len; i++) {
        fact = factorial(len - 1 - i);
        int index = n / fact;
        n %= fact;
        result[i] = digits[index] + '0';
        for (j = index; j < len - 1 - i; j++) {
            digits[j] = digits[j + 1];
        }
    }
    result[len] = '\0';
}

int main() {
    int digits[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    char result[11];
    int position = 1000000;
    findPermutation(position, digits, 10, result);
    printf("The millionth lexicographic permutation is: %s\n", result);

    return 0;
}
