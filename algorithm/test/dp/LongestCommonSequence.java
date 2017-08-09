package dp;

/**
 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。
 * 例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 * 测试样例："1A2C3D4B56",10,"B1D23CA45B6A",12 返回：6
 * 解析：设dp[n][m] ，为A的前n个字符与B的前m个字符的公共序列长度，
 * 则当A[n] == B[m]的时候，dp[i][j] = max(dp[i-1][j-1]+1, dp[i-1][j], dp[i][j-1])，
 * 否则，dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
 * Created by jjxx9 on 2017/4/3.
 */
public class LongestCommonSequence {
    public static int lcs (String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int n = chars1.length, m = chars2.length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (chars1[i] == chars2[0]) {   // 找出string1中与string2第一位相同的元素位置
                for (int j = i; j < n; j++) {
                    dp[j][0] = 1;
                }
                break;
            }

        }

        for (int i = 0; i < m; i++) {
            if (chars1[0] == chars2[i]) {   // 找出string2中与string1第一位相同的元素位置
                for (int j = i; j < m; j++) {
                    dp[0][j] = 1;
                }
                break;
            }

        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (chars1[i] == chars2[j]) dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1] + 1);
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        System.out.println(lcs("1A2C3D4B56", "B1D23CA45B6A"));
    }
}
