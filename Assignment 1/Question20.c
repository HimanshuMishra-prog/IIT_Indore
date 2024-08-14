/*Given two strings: s and t. Return the minimum number of operations required to convert s to
t. The possible operations are permitted:
(i) Insert a character at any position of the string.
(ii) Remove any character from the string.
(iii) Replace any character from the string with any other character.
Consider all operations have the exact cost.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int min(int a, int b, int c)
{
    if (a < b && a < c)
        return a;
    else if (b < a && b < c)
        return b;
    else
        return c;
}

int findDistance(char *str1, char *str2)
{
    int n = strlen(str1);
    int m = strlen(str2);
    int dp[n + 1][m + 1];
    for (int i = 0; i <= n; i++)
        dp[i][0] = i;
    for (int j = 0; j <= m; j++)
        dp[0][j] = j;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = 1 + min(dp[i - 1][j],   
                                   dp[i][j - 1],    
                                   dp[i - 1][j - 1] 
                );
            }
        }
    }

    return dp[n][m];
}

int main()
{
    char str1[100];
    char str2[100];

    printf("Enter the first string: ");
    fgets(str1, sizeof(str1), stdin);
    str1[strcspn(str1, "\n")] = '\0';

    printf("Enter the second string: ");
    fgets(str2, sizeof(str2), stdin);
    str2[strcspn(str2, "\n")] = '\0'; 

    printf("Minimum operations required: %d\n", findDistance(str1, str2));

    return 0;
}
