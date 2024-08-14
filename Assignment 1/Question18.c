/*19. Write a C program to compare two strings. (Use standard library string functions).*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main(){
    char str1[100];
    char str2[100];
    printf("Enter the first string");
    scanf("%99s", str1);
    printf("Enter the second string");
    scanf("%99s", str2);
    int len1 = strlen(str1);
    int len2 = strlen(str2);
    if(len1 != len2){
         printf("Strings are not same");
         return 0;
    }

    for(int i = 0; i< len1 && i < len2 ; i++){
        if(tolower(str1[i]) != tolower(str2[i])){
            printf("Strings are not same");
            return 0;
        }
    }
    printf("Strings are same");
    return 0;

}