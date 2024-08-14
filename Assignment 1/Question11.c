/*Write an efficient C program to find the largest and the second-largest elements of a given array.
Example: input: {203, 45, 1, 3, 200, 298},
output: largest: 298, second-largest: 203.*/

void findLargest(int arr[], int size, int *largest, int *second) 
{
    *largest = INT_MIN;
    *second = INT_MIN;

    for (int i = 0; i < size; i++)
    {
        if (arr[i] > *largest)
        {
            *second = *largest;
            *largest = arr[i];
        }
        else if (arr[i] > *second && arr[i] != *largest) 
        {
            *second = arr[i];
        }
    }
}

int main() {
    int size;
    printf("Enter the size of the array: ");
    scanf("%d", &size);

    int arr[size];
    printf("Enter the elements of the array:\n");
    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }

    int largest, second;
    findLargest(arr, size, &largest, &second);

    printf("Largest: %d\n", largest);
    printf("Second-largest: %d\n", second);

    return 0;
}

