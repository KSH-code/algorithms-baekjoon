#include <cstdio>
#include <stack>
#include <vector>
#include <string>
#include <string.h>
/**
 * https://www.acmicpc.net/problem/2504
 * BOJ 백준온라인져지 2504 괄호의 값 풀이
 */
using namespace std;
int main(){
    stack<char> characterList;
    int integerList[31] = {1}; // index 0 은 1
    char temp, compared, pre = '.';
    // temp 는 string 에서 하나씩 뽑아서 쓴다.
    // compared 는 ( or [ 가 들어가는데, 스택에서 빼서 쓴다.
    // pre 는 이전 괄호를 체크한다. 곱셈의 결합법칙에 의해 (()()) 일때 둘러싼 괄호는 0으로 처리해준다.
    char* string = new char[31]; // 입력 받을 string
    scanf("%s", string);
    int idx = 0, i = 0, length = strlen(string), tempInteger, result = 0;
    // idx 는
    while(i != length){
        temp = string[i++];
        if(temp == '(' || temp == '['){
            idx++;
            if(temp == '(')
                integerList[idx] = 2 * integerList[idx-1];
            if(temp == '[')
                integerList[idx] = 3 * integerList[idx-1];
            characterList.push(temp);
        }else{
            if(characterList.empty()){ // 올바른 괄호가 아닐경우
                result = 0;
                break;
            }
            compared = characterList.top(), characterList.pop();
            tempInteger = integerList[idx--];
            if(pre == ']' || pre == ')'){
                tempInteger = 0;
            }
            if(compared == '(' && temp == ')'){
                result += tempInteger;
            }else if(compared == '[' && temp == ']'){
                result += tempInteger;
            }else{ // 올바른 괄호가 아닐경우
                result = 0;
                break;
            }
        }
        pre = temp;
    }
    // 올바른 괄호가 아닐경우
    if(characterList.size()) result = 0;
    
    printf("%d", result);
    return 0;
}