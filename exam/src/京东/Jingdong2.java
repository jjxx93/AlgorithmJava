package 京东;

import java.util.Scanner;

/**
 * Created by 熊佳新 on 2017/9/8.
 */
public class Jingdong2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] dp = new long[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[1] = dp[0] + 5;
            dp[1] += (Math.sqrt(i) - 1) * 2;
            dp[1] += (Math.pow(i, 1.0/3) - 1) * 2;
        }

        System.out.println(dp[n - 1] % 1000000007);
    }
}
