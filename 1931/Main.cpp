#include <cstdio>
/**
 * https://www.acmicpc.net/problem/1931
 * BOJ 백준온라인져지 1931 회의실배정 풀이
 */
struct Time{
    int startTime, endTime;
};
bool isBiggerAThanB(Time &A, Time &B){
    if(A.endTime == B.endTime)
        return A.startTime > B.startTime;
    return A.endTime > B.endTime;
}
template <class T> void swap ( T& a, T& b )
{
  T c(a); a=b; b=c;
}
Time timeList[100001];
int i,j,mid;
Time pivot;
void quickSort(int l, int r){
    if(l < r) return;
    mid = (l + r) / 2;
    quickSort(l, mid - 1);
    quickSort(mid + 1, r);
    i = l, j = r;
    pivot = timeList[(i + j) / 2];
    do{

        while(!isBiggerAThanB(timeList[i], pivot)) i++;
        while(isBiggerAThanB(timeList[j], pivot)) j--;

        if(i <= j){
            swap(timeList[i], timeList[j]);
            i++, j--;
        }

    }while(i <= j);

}

int main(){
    int N;
    scanf("%d", &N);

    for(int i = 0; i < N; i++){
        scanf("%d%d", &timeList[i].startTime, &timeList[i].endTime);
    }

    quickSort(0, N - 1);
    
    int result = 0, endTime = -1;

    for(int i = 0; i < N; i++){
        if(timeList[i].startTime >= endTime){
            result++, endTime = timeList[i].endTime;
        }
    }

    printf("%d", result);
}