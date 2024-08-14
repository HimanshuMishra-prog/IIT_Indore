/*Write a C program that takes the equations (in the form of m and c) of two straight lines and
identifies whether they are parallel, perpendicular, or intersecting with an angle θ ̸= 90o using
switch-case.
Example: Input: m1 = 1, c1 = 7,m2 = −1, c2 = 5; Output: perpendicular
Note: Inputs represent the following equations: y = x + 7; y = −x + 5*/

#include <stdio.h>

int main() {
    int m1, c1, m2, c2;

    // Input slopes and intercepts
    printf("Enter the m and c of the first line: ");
    scanf("%lf %lf", &m1, &c1);
    printf("Enter the m and c of e second line: ");
    scanf("%lf %lf", &m2, &c2);
    if (m1 == m2) {
        printf("The lines are parallel.\n");
    } else if (m1 * m2 == -1) {
        printf("The lines are perpendicular.\n");
    } else {
        printf("The lines are intersecting.\n");
    }

    return 0;
}
