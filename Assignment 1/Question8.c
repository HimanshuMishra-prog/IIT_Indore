/*Given three coordinates (x1, y1), (x2, y2), (x3, y3) in a XY plane, write a C program to check
whether it is forming an Equilateral, Isosceles, or Scalene triangle. Also, report if the three
points are collinear.*/

#include <stdio.h>
#include <math.h>

double distance(double x1, double y1, double x2, double y2) {
    return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
}

int areCollinear(double x1, double y1, double x2, double y2, double x3, double y3) {
    double area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
    return (area == 0);
}

void checkTriangleType(double a, double b, double c) {
    if (a == b && b == c) {
        printf("The triangle is Equilateral.\n");
    } else if (a == b || b == c || a == c) {
        printf("The triangle is Isosceles.\n");
    } else {
        printf("The triangle is Scalene.\n");
    }
}

int main() {
    double x1, y1, x2, y2, x3, y3;

    printf("Enter first cordinate points: ");
    scanf("%lf %lf", &x1, &y1);

    printf("Enter second coordinate points: ");
    scanf("%lf %lf", &x2, &y2);

    printf("Enter third coordinate points: ");
    scanf("%lf %lf", &x3, &y3);

    double side1 = distance(x1, y1, x2, y2);
    double side2 = distance(x2, y2, x3, y3);
    double side3 = distance(x3, y3, x1, y1);

    if (areCollinear(x1, y1, x2, y2, x3, y3)) {
        printf("The points are collinear.\n");
    } else {
        checkTriangleType(side1, side2, side3);
    }

    return 0;
}

