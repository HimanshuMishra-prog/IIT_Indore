/*19. Write a C program to compare two strings. (Use standard library string functions).*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    char str1[100];
    char str2[100];
    printf("Enter the first string");
    scanf("%99s", str1);
    printf("Enter the second string");
    scanf("%99s", str2);
    int len = strlen(str1);
    
    if(strncmp(str1,str2, len) == 0){
        printf("The strings are same");
    }
    else{
        printf("The strings are different");
    }


}