import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N,M;
        String str1[] = br.readLine().split(" ");
        ArrayList<Integer> I_list = new ArrayList<>();
        double sq;
        N = Long.parseLong(str1[0]);
        M = Long.parseLong(str1[1]);
        for(int i = 2;i<=1000000;i++){
            sq = Math.sqrt(i);
            boolean check = false;
            for(int j = 2;j<=sq;j++){
                if(i%j==0){
                    check = true;
                    break;
                }
            }
            if(!check){
                I_list.add(i);
            }
        }
        long sum = 0;
        for(long i = N;i<=M;i++){
            for(int j = 0;j<I_list.size();j++){
                int temp = I_list.get(j);
                long pow = (long)(temp*temp);
                if(pow>i)
                    break;
                if(i%pow==0){
                    sum++;
                    break;
                }
            }
        }
        System.out.println(M-N-sum+1);
    }
}