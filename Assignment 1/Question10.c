/*Write a C program to encrypt a string as follows:
Replace all the a’s of the string with b.*/

#include <stdio.h>

void encryptString(char *str) {
    while (*str) {
        if (*str == 'a') {
            *str = 'b';
        }
        str++;
    }
}

int main() {
    char str[20000]; 
    printf("Enter the string to encrypt: ");
    scanf("%s", str);

    encryptString(str);

    printf("Encrypted string: %s\n", str);

    return 0;
}

