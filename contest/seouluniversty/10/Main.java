import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1[] = br.readLine().trim().split(" ");
        int N = Integer.parseInt(s1[0]);
        int M = Integer.parseInt(s1[1]);
        int L = Integer.parseInt(s1[2]);

        int H[] = new int[N];
        int W[] = new int[M];
        String s2[] = br.readLine().trim().split(" ");
        String s3[] = br.readLine().trim().split(" ");
        long result[]=new long[L];

        for(int i = 0;i<N;i++){
            H[i]=Integer.parseInt(s2[i]);
        }
        for(int i = 0;i<M;i++){
            W[i]=Integer.parseInt(s3[i]);
        }

        long temp;
        int temp_w;
        int temp_h;
        long area=M*N;
        for(int i = 1;i<=L;i++){
            temp=i;
            while(temp<=area){
                temp_w=(int)((temp-1)%M);
                temp_h=(int)((temp-1)/M);
                result[i-1]+=W[temp_w]*H[temp_h];
                temp+=L;
            }
        }
        for(int i = 0;i<L;i++){
            bw.write(result[i]+"\n");
        }
        bw.flush();
    }
}