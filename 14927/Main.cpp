#include <cstdio>
/**
 * https://www.acmicpc.net/problem/14927
 * BOJ 백준온라인져지 14927 전구 끄기 풀이
 */
int yyyy[] = {0, 0, 1, 0, -1};
int xxxx[] = {0, -1, 0, 1, 0};
int main(){
    int N;
    scanf("%d", &N);
    N++;

    int **lights = new int*[N];
    int **originLights = new int*[N];
    for (int i = 1; i < N; i++) {
        originLights[i] = new int[N];
        lights[i] = new int[N];
        for (int j = 1; j < N; j++) {
            scanf("%d", &lights[i][j]);
            originLights[i][j] = lights[i][j];
        }
    }
    int count = 0;
    for (int j = 1; j < N; j++) {
        if (originLights[N - 1][N - j] == originLights[1][j]) {
            count++;
            for (int k = 0; k < 5; k++) {
                int y = j + xxxx[k], x = 1 + yyyy[k];
                if (x <= 0 || y <= 0 || x >= N || y >= N) continue;                
                lights[x][y] = lights[x][y] * -1 + 1;
            }
        }
    }
    for (int i = 2; i < N; i++) {
        for (int j = 1; j < N; j++) {
            if (lights[i - 1][j]) {
                count++;
                for (int k = 0; k < 5; k++) {
                    int y = j + xxxx[k], x = i + yyyy[k];
                    if (x <= 0 || y <= 0 || x >= N || y >= N) continue;                
                    lights[x][y] = lights[x][y] * -1 + 1;
                }
            }
        }
    }
    for (int i = 1; i < N; i++) {
        for (int j = 1; j < N; j++) {
            if (lights[i][j]) {
                printf("-1");
                return 0;
            }
        }
    }
    printf("%d", count);
}