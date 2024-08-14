/*Write a C program to find the frequency of a keyword in a given text file.
(Called as “term frequency”.)
Example: Text file contains: “India, officially the Republic of India, is a country in South Asia.”
input keyword: “India”. output: 2.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define FILE_BUFFER 99999
int countKeywordFrequency(const char *text, const char *keyword) {
    int count = 0;
    size_t keywordLength = strlen(keyword);
    size_t textLength = strlen(text);

    for (size_t i = 0; i <= textLength - keywordLength; i++) {
        if (strncmp(&text[i], keyword, keywordLength) == 0) {
            count++;
        }
    }

    return count;
}

int main() {
    FILE *file;
    char filename[256];
    char keyword[256];
    char text[FILE_BUFFER];
    size_t length = 0;
    printf("Enter the filename: ");
    if (scanf("%255s", filename) != 1) {
        fprintf(stderr, "Error reading filename\n");
        return EXIT_FAILURE;
    }
    printf("Enter the keyword: ");
    if (scanf("%255s", keyword) != 1) {
        fprintf(stderr, "Error reading keyword\n");
        return EXIT_FAILURE;
    }
    file = fopen(filename, "r");
    if (file == NULL) {
        perror("Error opening file");
        return EXIT_FAILURE;
    }
    length = fread(text, 1, sizeof(text) - 1, file);
    text[length] = '\0';
    fclose(file);
    int totalCount = countKeywordFrequency(text, keyword);
    printf("The keyword \"%s\" appears %d times in the file.\n", keyword, totalCount);

    return EXIT_SUCCESS;
}
