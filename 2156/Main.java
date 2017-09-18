import java.io.*;
import java.util.*;
class Main{
        private static int mResult = 0;
        private static int n;
        public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int mList[] = new int[n+1];
        int dp[] = new int[n+1];
        for(int i = 1;i<=n;i++){
            mList[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = mList[1];
        int temp1,temp2;
        for(int i = 2;i<=n-2;i++){
            temp1 = dp[i-1]+mList[i]+mList[i+2];
            temp2 = dp[i-2]+mList[i]+mList[i+1];
            dp[i] = Math.max(temp1, temp2);
            if(temp1>temp2){
                i++;
            }
        }
        for(int i=n-1;i<=n;i++){
            dp[i] = Math.max(mList[i]+dp[i-3]+dp[i-1], mList[i]+dp[i-2]+dp[i-3]);
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }
}