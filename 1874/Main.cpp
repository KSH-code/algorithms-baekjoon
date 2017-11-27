#include <cstdio>
#include <stack>
#include <vector>
/**
 * https://www.acmicpc.net/problem/1874
 * BOJ 백준온라인져지 1874 스택 수열 풀이
 */
using namespace std;
int main(){
    stack <int> stack;
    vector <char> vector;
    int N,temp=0;
    int c[100000],idx=0;
    scanf("%d",&N);
    while(N--) scanf("%d",&c[idx++]);
    for(int i = 0; i<idx; i++){
        stack.push(i+1);
        vector.push_back('+');
        while(stack.size() && stack.top() == c[temp])
            stack.pop(), temp++, vector.push_back('-');
    }
    if(stack.size()) printf("NO");
    else{
        for(int i = 0, size = vector.size(); i<size; i++)
            printf("%c\n",vector[i]);
    }
    return 0;
}
// class Node{
//     public:
//         int number;
//         Node(int n);
//         Node next;
// };
// Node::Node(int n){
//     number = n;
// }
// class Stack{
//     public:
//         Node head;
//         void push(int n);
//         int pop();
//         int size();
//     private:
//         int size = 0;
// };
// void Stack::push(int n){
//     Node node = new Node(n);
//     if(head != NULL){
//         node.next = head;
//     }
//     head = node;
//     size++;
// }
// int Stack::pop(){
//     if(head == NULL) return -1;
//     int number = head.number;
//     head = head.next;
//     size--;
//     return number;
// }
// int Stack::size(){
//     return size;
// }