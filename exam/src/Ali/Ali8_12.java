package Ali;

import java.util.Scanner;
/**
 * Created by xiongjiaxin on 2017/8/12.
 */
public class Ali8_12 {
    public static int count (int N,int P,int M, int T ) {
        int length = P - T;
        if(length < 0) {
            length = -length;
        }

        if (length > M) {
            return 0;
        } else if (length == M){
            return 1;
        } else {
            int[][] dp = new int[2][10000];

            dp[0][P] = 1;
            int cur = 0;
            for (int i = 0; i <= M; i++) {
                cur ^= 1;
                for(int j=1;j<=N;j++){
                    dp[cur][j] = dp[cur^1][j-1] + dp[cur^1][j+1];
                }
            }

            return dp[cur][T];
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long res;
        int n= Integer.parseInt(in.nextLine().trim());
        int p= Integer.parseInt(in.nextLine().trim());
        int m= Integer.parseInt(in.nextLine().trim());
        int t= Integer.parseInt(in.nextLine().trim());
        res = count(n, p, m, t);
        System.out.println(String.valueOf(res));
    }
}
