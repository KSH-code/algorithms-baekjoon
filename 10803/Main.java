import java.util.*;
import java.io.*;
/**
 * BOJ 10803 정사각형 만들기
 */
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str1[] = br.readLine().split(" ");
        int N = Integer.parseInt(str1[0]);
        int M = Integer.parseInt(str1[1]);

        int dp[][] = new int[10001][101];

        int max = max(N, M);
        int min = min(N, M);
        for(int i = 1; i<=max; i++){
            dp[i][1] = i;
            dp[i][i] = 1;
        }

        /**
         *  아이디어 : 아직 너무 복잡한
         */

        bw.write(String.valueOf(dp[max][min]));
        bw.flush();
    }
    
    private static int max(int a, int b){
        if(a > b){
            return a;
        }else{
            return b;
        }
    }
    private static int min(int a, int b){
        if(a < b){
            return a;
        }else{
            return b;
        }
    }
}