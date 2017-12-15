#include <cstdio>
#include <queue>
/**
 * https://www.acmicpc.net/problem/14923
 * BOJ 백준온라인져지 14923 미로 탈출 풀이
 */
#define INF 99999999
using namespace std;
int xxxx[] = {0, 1, 0 , -1};
int yyyy[] = {-1, 0, 1 , 0};

int min(int a, int b){
    return a < b ? a : b;
}

int main(){
    int rowSize, columnSize;
    scanf("%d%d", &rowSize, &columnSize);
    rowSize++, columnSize++;
    int ***resultArray = new int**[rowSize], **map = new int*[rowSize];
    for(int i = 1; i < rowSize; i++){
        resultArray[i] = new int*[columnSize];
        map[i] = new int[columnSize];
        for(int j = 1; j < columnSize; j++){
            resultArray[i][j] = new int[3];
        }
    }

    int startX, startY;
    int endX, endY;

    scanf("%d%d", &startX, &startY);
    scanf("%d%d", &endX, &endY);
    
    for(int i = 1; i < rowSize; i++)
        for(int j = 1; j < columnSize; j++)
            scanf("%d", &map[i][j]), resultArray[i][j][0] = resultArray[i][j][1] = INF;
    resultArray[startX][startY][0] = resultArray[startX][startY][1] = 0;
    queue<pair<int, int> > queue;

    queue.push(make_pair(startX, startY));

    while(queue.size()){
        pair<int, int> polledData = queue.front();
        queue.pop();
        int x = polledData.first;
        int y = polledData.second;
        int z = resultArray[x][y][2];
        int moveCount = resultArray[x][y][z] + 1;
        for(int i = 0 ; i < 4; i++){
            int newX = xxxx[i] + x;
            int newY = yyyy[i] + y;
            if(newX <= 0 || newX >= rowSize || newY <= 0 || newY >= columnSize) continue;
            if(map[newX][newY] == 0 && moveCount < resultArray[newX][newY][z]){
                queue.push(make_pair(newX, newY)), resultArray[newX][newY][z] = moveCount,
                resultArray[newX][newY][2] = z;
            }else if(map[newX][newY] == 1 && z == 0 && moveCount < resultArray[newX][newY][1]){
                queue.push(make_pair(newX, newY)), resultArray[newX][newY][1] = moveCount,
                resultArray[newX][newY][2] = 1;
            }
        }
    }
    int result = min(resultArray[endX][endY][0], resultArray[endX][endY][1]);
    if(result == INF) result = -1;
    printf("%d", result);
}