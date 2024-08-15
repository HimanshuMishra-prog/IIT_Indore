/*Write a C program that takes n distinct integers as input and stores them in an array such that
every ith (0 ≤ i ≤ (n−1)) element in the array is bigger than 2×(i+1)th and (2×(i+1)+1)th
elements. Print the array.*/

#include <stdio.h>
#include <stdlib.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}
void heapify(int arr[], int n, int i) {
    int smallest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] < arr[smallest])
        smallest = left;
    if (right < n && arr[right] < arr[smallest])
        smallest = right;

    if (smallest != i) {
        swap(&arr[i], &arr[smallest]);
        heapify(arr, n, smallest);
    }
}

void buildHeap(int arr[], int n) {
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);
}

void sortFirstKElements(int arr[], int k , int n) {
    buildHeap(arr, k);

    for (int i = k; i < n; i++) {
        if (arr[i] > arr[0]) {
            swap(&arr[0], &arr[i]);
            heapify(arr, k, 0);
        }
    }
}

void printArray(int arr[], int n , int k) {
    for(int i = 0 ; i <= k ; i++){
      swap(&arr[0], &arr[k-i]);
      heapify(arr, k-i , 0);
    }
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main() {
    int n;

    printf("Enter the number of elements: ");
    scanf("%d", &n);

    if (n < 1) {
        printf("The number of elements must be at least 1.\n");
        return 1;
    }

    int *arr = (int *)malloc(n * sizeof(int));
    if (arr == NULL) {
        printf("Memory allocation failed.\n");
        return 1;
    }

    printf("Enter %d distinct integers:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    int k = (n - 1) / 2;
    sortFirstKElements(arr, k + 1 , n);
    printf("Array after sorting:\n");
    printArray(arr, n , k);

    free(arr);
    return 0;
}
