import java.util.*;
import java.io.*;
/**
 * BOJ 1031 스타 대결
 * 풀이
 * 1. N을 입력받고 M을 받을때마다 처리해준다.(주석해놓음)
 * 2. N,M을 입력받고 N에서 하나씩 돌린다.(사전순으로 하는 법: 맨 뒤에부터 같은 숫자가 있나 찾아서 거기에 먼저 넣는다.)
 */
class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str1[] = br.readLine().split(" ");
        int N = Integer.parseInt(str1[0]);
        int M = Integer.parseInt(str1[1]);
        
        int edges1[] = new int[N];
        int edges2[] = new int[M];
        int result[][] = new int[N][M];
        String str2[] = br.readLine().split(" ");
        String str3[] = br.readLine().split(" ");
        int n = 0, m = 0;
        for(int i = 0; i<N; i++){
            n += edges1[i] = Integer.parseInt(str2[i]);
        }
        for(int i = 0; i<N; i++){
            m += edges2[i] = Integer.parseInt(str3[i]);
        }
        if(n != m){
            System.out.println(-1);
            return;
        }
        // N 이랑 M 을 계산
        // N 에 있는것을 M 에 하나씩 비교
        boolean visitedEdges2[] = new boolean[M];  
        boolean changed = false;      
        for(int i = 0; i<M; i++){
            changed = false;
            for(int k = M-1; k>i; k--){
                if(visitedEdges2[k]) continue;
                if(edges2[i] > edges2[k]){
                    visitedEdges2[k] = true;
                    i = k;
                    changed = true;
                    break;
                }
            }
            boolean visited[] = new boolean[N];
            for(int j = 0; j<N; j++){ // edges1
                if(edges1[j] > 0){
                    if(!visited[j]){
                        if(edges2[i] > 0){
                            result[j][i] = 1;
                            edges1[j]--;
                            edges2[i]--;
                            visited[j] = true;
                        }else{
                            for(int k = 0; k<j; k++){
                                if(!visited[k]) continue;
                                if(edges1[j]-1 > edges1[k]){
                                    visited[k] = false;
                                    result[k][i] = 0;
                                    edges1[k]++;
                                    edges2[i]++;
                                    j--;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(changed) i = 0;
        }
        for(int i = 0; i<N; i++){
            if(edges1[i] > 0){
                System.out.println(-1);
                return;
            }
        }
        for(int j = 0; j<M; j++){
            if(edges2[j] > 0){
                System.out.println(-1);
                return;
            }
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                bw.write(String.valueOf(result[i][j]));
            }
            bw.write("\n");
        }
        bw.flush();
    }
    
}
/* 1번째 풀이
class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str1[] = br.readLine().split(" ");
        int N = Integer.parseInt(str1[0]);
        int M = Integer.parseInt(str1[1]);
        int n[] = new int[N];
        int m[] = new int[M];
        int edges1[] = new int[N];
        int edges2[] = new int[M];
        int result[][] = new int[N][M];
        String str2[] = br.readLine().split(" ");
        String str3[] = br.readLine().split(" ");
        for(int i = 0; i<N; i++){
            n[i] = Integer.parseInt(str2[i]);
            edges1[i] = Integer.parseInt(str2[i]);
        }
        for(int i = 0; i<M; i++){
            m[i] = Integer.parseInt(str3[i]);
            edges2[i] = Integer.parseInt(str3[i]);
            for(int j = 0; j<N; j++){
                if(M-n[j]+1 <= m[i] && edges1[j] > 0){
                    edges1[j]--;
                    result[j][i] = 1;
                    edges2[i]--;
                }
            }
        }
        for(int i = 0; i<N; i++){
            if(edges1[i] < 0){
                System.out.println(-1);
                return;
            }
        }
        for(int i = 0; i<M; i++){
            if(edges2[i] < 0){
                System.out.println(-1);
                return;
            }
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                bw.write(String.valueOf(result[i][j]));
            }
            bw.write("\n");
        }
        bw.flush();
    }
    
}
*/