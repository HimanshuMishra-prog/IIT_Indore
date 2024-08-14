/*The arithmetic sequence 1487, 4817, and 8147, in which each of the terms increases by 3330,
is unusual in two ways: (i) each of the three terms is prime, and, (ii) each of the 4-digit numbers
are permutations of one another.
There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this
property, but there is one other 4-digit increasing sequence.
What 12-digit number do you form by concatenating the three terms in this sequence?*/

// #include <stdio.h>
// #include <stdlib.h>
// #include <stdbool.h>
// #include <string.h>


// bool check_prime(int n) {
//     if (n <= 1) return false;
//     if (n == 2) return true;
//     if (n % 2 == 0) return false;
//     for (int i = 3; i * i <= n; i += 2) {
//         if (n % i == 0) return false;
//     }
//     return true;
// }
// void sort_chars(char* str) {
//     int len = strlen(str);
//     for (int i = 0; i < len - 1; i++) {
//         for (int j = i + 1; j < len; j++) {
//             if (str[i] > str[j]) {
//                 char temp = str[i];
//                 str[i] = str[j];
//                 str[j] = temp;
//             }
//         }
//     }
// }
// bool check_permutation(int a, int b) {
//     char str_a[5], str_b[5];
//     sprintf(str_a, "%d", a);
//     sprintf(str_b, "%d", b);

//     sort_chars(str_a);
//     sort_chars(str_b);

//     return strcmp(str_a, str_b) == 0;
// }

// bool check_arithmetic_sequence(int a, int b, int c) {
//     return (b - a == c - b);
// }
// void find_sequences(int primes[], int num_primes) {
//     for (int i = 0; i < num_primes; i++) {
//         for (int j = i + 1; j < num_primes; j++) {
//             for (int k = j + 1; k < num_primes; k++) {
//                 if (check_permutation(primes[i], primes[j]) &&
//                     check_permutation(primes[j], primes[k]) &&
//                     check_arithmetic_sequence(primes[i], primes[j], primes[k])) {
//                     printf("Sequence: %d, %d, %d\n", primes[i], primes[j], primes[k]);
//                 }
//             }
//         }
//     }
// }


// int main() {
//     int min = 1000;
//     int max = 9999;
//     int max_primes = max - min + 1;
//     int primes[max_primes];
//     int num_primes = 0;

//     for (int i = min; i <= max; i++) {
//         if (check_prime(i)) {
//             primes[num_primes++] = i;
//         }
//     }

//     find_sequences(primes, num_primes);

//     return 0;
// }