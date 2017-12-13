#include <cstdio>
/**
 * https://www.acmicpc.net/problem/1456
 * BOJ 백준온라인져지 1456 거의 소수 풀이
 * http://ksh-code.tistory.com/102
 */
int main(){
    long long min, max;
    int count = 0;
    scanf("%lld%lld", &min, &max);
    for(long long i = 2; i * i <= max; i++){
        for(long long j = i * i; j <= max; j *= i){
            count++;
        }
    }
    printf("%d", count);
}