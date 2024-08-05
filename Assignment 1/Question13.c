/*Write a function in C to find the highest frequency element in an array.
Example: input: {1, 3, 5, 1, 7, 5, 4, 3, 1, 3, 5, 5, 4, 5, 1, 5},
output: Element: 5; Frequency: 6.*/

#include <stdio.h>
#include <stdlib.h>

#define TABLE_SIZE 1000

void findHighestFrequencyElement(int arr[], int size) {
    int *frequency = (int *)calloc(TABLE_SIZE, sizeof(int));
    if (frequency == NULL) {
        printf("Memory allocation failed\n");
        return;
    }
    int maxFrequency = 0;
    int mostFrequentElement = arr[0];

    for (int i = 0; i < size; i++) {
        int index = arr[i] % TABLE_SIZE;
        frequency[index]++;
        if (frequency[index] > maxFrequency) {
            maxFrequency = frequency[index];
            mostFrequentElement = arr[i];
        }
    }

    printf("Element: %d; Frequency: %d\n", mostFrequentElement, maxFrequency);

    free(frequency);
}

int main() {
    int size;
    printf("Enter the size of the array: ");
    scanf("%d", &size);

    int *arr = (int *)malloc(size * sizeof(int));
    if (arr == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }
    printf("Enter the elements of the array:\n");
    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }
    findHighestFrequencyElement(arr, size);
    free(arr);

    return 0;
}

