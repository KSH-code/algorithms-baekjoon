#include <cstdio>
/**
 * https://www.acmicpc.net/problem/14927
 * BOJ 백준온라인져지 14927 전구 끄기 풀이
 */
int xxxx[] = {0, 0, 1, 0, -1};
int yyyy[] = {0, -1, 0, 1, 0};
int main(){
    int N;
    scanf("%d", &N);
    N++;

    int **lights = new int*[N];
    for(int i = 0; i < N; i++){
        lights[i] = new int[N];
        if(i > 0){
            for(int j = 1; j < N; j++)
                scanf("%d", &lights[i][j]);
        }
    }
    int count = 0;
    
    for(int i = 2; i < N; i++){
        for(int j = 1; j < N; j++){
            if(lights[i - 1][j]){
                count++;
                for(int k = 0; k < 5; k++){
                    int x = j + xxxx[k], y = i + yyyy[k];
                    if(x <= 0 || y <= 0 || x >= N || y >= N) continue;                
                    lights[x][y] = lights[x][y] * -1 + 1;
                }
            }
        }
    } 

    for(int i = 1; i < N; i++){
        for(int j = 1; j < N; j++){
            printf("%d ", lights[i][j]);
        }
        printf("\n");
    }
    printf("%d\n", count);
    for(int i = 0; i < 1; i++){
        for(int j = 1; j < N; j++){
            if(lights[i + 1][j] || lights[i][j]){
                count++;
                for(int k = 0; k < 5; k++){
                    int x = j + xxxx[k], y = i + yyyy[k];
                    if(x <= 0 || y <= 0 || x >= N || y >= N) continue;                
                    lights[x][y] = lights[x][y] * -1 + 1;
                }
            }
        }
    } 
    for(int i = 1; i < N; i++){
        for(int j = 1; j < N; j++){
            printf("%d ", lights[i][j]);
        }
        printf("\n");
    }
    printf("%d\n", count);

    for(int i = 1; i < N; i++){
        for(int j = 1; j < N; j++){
            if(lights[i][j]){
                printf("-1");
                return 0;
            }
        }
    }
    printf("%d", count);
}