package dp;

/**
 * Created by jjxx9 on 2017/4/3.
 * 有一个矩阵map，它每个格子有一个权值。
 * 从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 * 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
 * 测试样例：[[1,2,3],[1,1,1]],2,3 返回：4
 * 解析：设dp[n][m]为走到n*m位置的路径长度，那么显而易见dp[n][m] = min(dp[n-1][m]+map[n-1][m],dp[n][m-1]+map[n][m-1]);
 */
public class Grid {
    /**
     * 返回最小路径和
     * @param map 权值矩阵
     * @param n 行数
     * @param m 列数
     * @return 最小路径和
     */
    public static int getMinLength(int[][] map, int n, int m) {
        if (map == null || n == 0 || m == 0) return 0;

        int[][] lengths = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                lengths[i][0] += map[j][0];     // 第一行，只往右走
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                lengths[0][i] += map[0][j];     // 第一列，只往下走
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {       // dp[n][m] = min(dp[n-1][m]+map[n-1][m],dp[n][m-1]+map[n][m-1])
                lengths[i][j] = Math.min((lengths[i-1][j] + map[i-1][j]), (lengths[i][j-1] + map[i][j-1]));
            }
        }

        return lengths[n-1][m-1];
    }

    public static void main(String[] args) {
        int[][] map = {{1,2,3},{1,1,1}};
        System.out.println(getMinLength(map, 2, 3));
    }
}
