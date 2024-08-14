/*You have two sets A and B containing n and m (1 ≤ n,m ≤ 1000) distinct integers, respectively.
Implement the following set of operations. Write down a separate function for each of
the following operations.
(i) The union of two sets A ∪ B.
(ii) The intersection between two sets A ∩ B.
(iii) The set difference A \ B and B \ A
(iv) The symmetric difference AΔB = (A ∪ B) \ (A ∩ B)
Write down a print function to print the output of each of the above operations.*/

#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 1000

void unionSets(int *A, int n, int *B, int m) {
    int *unionSet = (int *)malloc((n + m) * sizeof(int));
    int size = 0;
    for (int i = 0; i < n; i++) {
        unionSet[size++] = A[i];
    }
    for (int i = 0; i < m; i++) {
        int found = 0;
        for (int j = 0; j < n; j++) {
            if (B[i] == A[j]) {
                found = 1;
                break;
            }
        }
        if (!found) {
            unionSet[size++] = B[i];
        }
    }
    
    printf("Union: ");
    outputValues(unionSet, size);
    
    free(unionSet);
}
void intersectionSets(int *A, int n, int *B, int m) {
    int *interSet = (int *)malloc((n < m ? n : m) * sizeof(int));
    int size = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (A[i] == B[j]) {
                interSet[size++] = A[i];
                break;
            }
        }
    }
    
    printf("Intersection: ");
    outputValues(interSet, size);
    
    free(interSet);
}

void differenceAB(int *A, int n, int *B, int m) {
    int *differenceSet = (int *)malloc(n * sizeof(int));
    int size = 0;

    for (int i = 0; i < n; i++) {
        int found = 0;
        for (int j = 0; j < m; j++) {
            if (A[i] == B[j]) {
                found = 1;
                break;
            }
        }
        if (!found) {
            differenceSet[size++] = A[i];
        }
    }
    
    printf("A \\ B: ");
    outputValues(differenceSet, size);
    
    free(differenceSet);
}
void differenceBA(int *A, int n, int *B, int m) {
    int *differenceSet = (int *)malloc(m * sizeof(int));
    int size = 0;
    for (int i = 0; i < m; i++) {
        int found = 0;
        for (int j = 0; j < n; j++) {
            if (B[i] == A[j]) {
                found = 1;
                break;
            }
        }
        if (!found) {
            differenceSet[size++] = B[i];
        }
    }
    
    printf("B \\ A: ");
    outputValues(differenceSet, size);
    
    free(differenceSet);
}

void symmetricDifference(int *A, int n, int *B, int m) {
    int *unionSet = (int *)malloc((n + m) * sizeof(int));
    int *interSet = (int *)malloc((n < m ? n : m) * sizeof(int));
    int unionSize = 0, intersectionSize = 0;
    

    for (int i = 0; i < n; i++) {
        unionSet[unionSize++] = A[i];
    }
    for (int i = 0; i < m; i++) {
        int found = 0;
        for (int j = 0; j < n; j++) {
            if (B[i] == A[j]) {
                found = 1;
                break;
            }
        }
        if (!found) {
            unionSet[unionSize++] = B[i];
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (A[i] == B[j]) {
                interSet[intersectionSize++] = A[i];
                break;
            }
        }
    }
    int *symmetricDiffSet = (int *)malloc(unionSize * sizeof(int));
    int symDiffSize = 0;

    for (int i = 0; i < unionSize; i++) {
        int found = 0;
        for (int j = 0; j < intersectionSize; j++) {
            if (unionSet[i] == interSet[j]) {
                found = 1;
                break;
            }
        }
        if (!found) {
            symmetricDiffSet[symDiffSize++] = unionSet[i];
        }
    }

    printf("Symmetric Difference: ");
    outputValues(symmetricDiffSet, symDiffSize);

    free(unionSet);
    free(interSet);
    free(symmetricDiffSet);
}

void outputValues(int *set, int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", set[i]);
    }
    printf("\n");
}

int main() {
    int A[MAX_SIZE], B[MAX_SIZE];
    int n, m;
    printf("Enter the number of elements in set A: ");
    scanf("%d", &n);
    printf("Enter the elements of set A: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &A[i]);
    }

    printf("Enter the number of elements in set B: ");
    scanf("%d", &m);
    printf("Enter the elements of set B: ");
    for (int i = 0; i < m; i++) {
        scanf("%d", &B[i]);
    }

    unionSets(A, n, B, m);
    intersectionSets(A, n, B, m);
    differenceAB(A, n, B, m);
    differenceBA(A, n, B, m);
    symmetricDifference(A, n, B, m);

    return 0;
}
