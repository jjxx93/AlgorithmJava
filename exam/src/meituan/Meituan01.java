package meituan;

import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/8/31.
 */
public class Meituan01 {
    public static int maxLength(int[] a,int K){
        if(a == null || a.length == 0) {
            return 0;
        }

        int max = 0;
        int[] dp = new int[a.length];
        dp[0] = a[0] % K;
        for(int i = 1; i < a.length; i++) {
            dp[i] = (dp[i-1] + a[i]) % K;
        }

        for(int i = 0;i < dp.length;i++) {
            if(dp[i] == 0)
                max = i+1;
        }

        for(int i = 1; i < K; i++) {
            int pre = 0;
            int back = dp.length-1;
            while(dp[pre]!=i && pre<back) {
                pre++;
            }
            while(dp[back]!=i && back>pre) {
                back--;
            }

            int len = back - pre;
            if (len > max) {
                max = len;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

//        int sum;
//        int maxLength = 0;
//        for(int i = 0; i < n; i++) {
//            sum = 0;
//            for(int j = i; j < n; j++) {
//                sum += a[j];
//                if(sum % k == 0) {
//                    if (j - i + 1 > maxLength) {
//                        maxLength = j - i + 1;
//                    }
//                }
//            }
//        }

        System.out.println(maxLength(a, k));
    }
}

/*
5
1 2 3 4 5
5

6
3 1 2 7 7 7
5
 */
