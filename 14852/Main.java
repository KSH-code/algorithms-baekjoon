import java.io.*;
import java.util.*;

/**
 * BOJ 14852 타일채우기 3
 */
public class Main{
    private static final int MOD = (int)(1e+9)+7;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N+1];
        int DP[] = new int[N+1];
        DP[0] = 0;
        DP[1] = 1;
        dp[1] = 1;
        if(N>1){
            DP[2] = 2;
            dp[2] = 2;
        }
        for(int i = 3; i<=N; i++){
            DP[i] = (DP[i - 1] + DP[i - 2]) % MOD;
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        bw.write(String.valueOf((dp[N]+DP[N])%MOD));

        bw.flush();

    }
}