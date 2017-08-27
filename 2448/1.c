/**
 * @author [KSH-Code]
 * @email [tjdgnsqn133@gmail.com]
 * @create date 2017-08-27 08:44:59
 * @modify date 2017-08-27 08:44:59
 * @desc [https://www.acmicpc.net/problem/2448]
*/
#include <stdio.h>
void changeStar(int *n)
{
    if (*n == 1)
    {
        *n = 2;
    }
    else if (*n == 2)
    {
        *n = 5;
    }
    else
    {
        *n = 1;
    }
}
void printStar(int n)
{
    switch (n)
    {
    case 1:
        printf("*");
        break;
    case 2:
        printf("* *");
        break;
    case 5:
        printf("*****");
        break;
    }
}
int main(void)
{
    int length, i, j, star = 1, klength,k, t = 1, tempt;
    scanf("%d", &length);
    for (i = 1; i <= length; i++)
    {
        if (length > i)
        {
            for (j = length - 1; j >= i; j--)
                printf(" ");
        }
        if (i % 3 == 1 && i > 1)
        {
            klength = (i - 1) / 3;
            for (k=1;)
            {
            }
            t *= 2;
        }
        printStar(star);
        if (length > i)
        {
            for (j = length; j >= i; j--)
                printf(" ");
            printf("\n");
        }
        changeStar(&star);
    }
    return 0;
}
