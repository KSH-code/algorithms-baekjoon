import java.io.*;
import java.util.*;
class Main{
        private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        private static boolean MN[][];
        private static int M,N;
        private static int result=0;
        private static boolean mCheck=false;
        private static boolean mTemp=false;
        public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1[] = br.readLine().split(" ");
        M = Integer.parseInt(str1[0]);
        N = Integer.parseInt(str1[1]);
        String str2[];
        MN = new boolean[M][N];
        for(int i = 0;i<M;i++){
            str2 = br.readLine().split(" ");
            for(int j = 0;j<N;j++)
                MN[i][j] = Integer.parseInt(str2[j]) == 1;
        }
        check(0,0);        
        bw.write(String.valueOf(result));
        bw.flush();
    }
    private static void check(int x, int y){
        if(MN[x][y]){
            MN[x][y] = false;
                if(x+1<M){
                    if(y+1<N){
                        if(MN[x+1][y+1]){
                            MN[x+1][y+1] = true;
                            mTemp=true;
                            if(!mCheck){
                                mCheck = true;
                                result++;
                            }
                        }
                    }else{
                        if(MN[x+1][y]){
                            mTemp=true;
                            MN[x+1][y] = true;
                            if(!mCheck){
                                mCheck = true;
                                result++;
                            }
                        }
                    }
                    if(y+1<N){
                        mTemp=true;
                        MN[x][y+1] = true;
                        if(!mCheck){
                            mCheck = true;
                            result++;
                        }
                    }
                
        }else{
                mCheck=false;
            }
        }
        if(x+1==M)
            return;
        else
            check(x+1,y);
        if(y+1==N)
            return;
        else
            check(x,y+1);
    }
}