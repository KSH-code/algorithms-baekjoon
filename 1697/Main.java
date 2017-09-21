import java.util.*;
import java.io.*;

public class Main {
    private static int min = Integer.MAX_VALUE;
    private static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1[] = br.readLine().split(" ");
		N = Integer.parseInt(str1[0]);
        M = Integer.parseInt(str1[1]);
        
        bw.write(String.valueOf(move(M, 0)));
		bw.flush();
    }
    private static int move(int current, int count){
        count++;
        if(current==N){
            return count-1;
        }else{
            if(current%2==1){
                if(Math.abs(N-((current-1)/2))<Math.abs(N-((current+1)/2))){
                    return move(current-1, count);
                }else{
                    return move(current+1, count);
                }
            }else{
                if(N>current){
                    return move(current+1, count);
                }
                return move(current/2, count);
            }
        }
    }
}