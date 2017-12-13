#include <cstdio>
/**
 * https://www.acmicpc.net/problem/14921
 * BOJ 백준온라인져지 14921 용액 합성하기 풀이
 */
using namespace std;
int abs(int a){
    return a > 0 ? a : -a;
}
int min(int a, int b){
    int aa = abs(a);
    int bb = abs(b);
    return aa < bb ? a : b;
}
int main(){
    int N;
    scanf("%d", &N);
    int *list = new int[N];
    int negativeN = -1, positiveN = -1;
    for(int i = 0; i < N; i++){
        scanf("%d", &list[i]);
        if(list[i] >= 0 && positiveN == -1){
            positiveN = i;
        }
        if(list[i] < 0 && negativeN == -1){
            negativeN = i;
        }
    }
    int maximum = 1000000000, l = 0, r = N - 1;
    bool left = false;
    if(positiveN == -1) maximum = list[N - 1] + list[N - 2];
    else if(negativeN == -1) maximum = list[0] + list[1];
    else{
        do{
            if(abs(maximum) > abs(list[l] + list[r])){
                maximum = list[l] + list[r];
                if(positiveN == r) l++;
                else r--;
            }else{
                if(abs(list[l] + list[r]) > abs(list[l] + list[r - 1])) r--;
                else l++;
            }
        }while(l < positiveN && r >= positiveN);
    }
    printf("%d", maximum);
}