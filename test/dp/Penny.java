package dp;

/**
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 * 测试样例：[1,2,4],3,3 返回：2
 * 解析：设dp[n][m]为使用前n种货币凑成的m的种数，那么就会有两种情况：
 * 当m >= penney[n]时 dp[n][m] = dp[n-1][m] + dp[n-1][m-penney[n]]，
 * 否则，dp[n][m] = dp[n-1][m]
 * Created by jjxx9 on 2017/4/3.
 */
public class Penny {
    /**
     * 计算凑集方法数
     * @param penny 货币面值
     * @param n 使用货币种数
     * @param aim 目标值
     * @return 方法数
     */
    public static int countWays(int[] penny, int n, int aim) {
        if(n == 0 || penny == null || aim < 0) {
            return 0;
        }
        int[][] pd = new int[n][aim + 1];   // dp[n][m]为使用前n种货币凑成的m的种数
        for(int i = 0; i < n; i++) {
            pd[i][0] = 1;   // 凑成0的方法有1种
        }
        for(int i = 1; penny[0] * i <= aim; i++) {
            pd[0][penny[0]*i] = 1;          // 只使用第一种货币凑成m的方法唯一
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= aim; j++) {
                if(j >= penny[i]) {
                    pd[i][j] = pd[i-1][j] + pd[i][j-penny[i]];
                } else {
                    pd[i][j] = pd[i-1][j];
                }
            }
        }
        return pd[n-1][aim];
    }

    public static void main(String[] args) {
        int[] penny = {2, 4, 5};
        System.out.println(countWays(penny, 3, 3));
    }
}

