package dp;

/**
 * Created by jjxx9 on 2017/4/3.
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。
 * 设f(n)为上n级台阶的方法，要上到n级台阶的最后一步有两种方式：从n-1级台阶走一步；从n-1级台阶走两步
 * 有公式f(n) = f(n-1) + f(n-2)
 */
public class Ladder {
    /**
     * 求上阶梯的方法数（递归方式）
     * @param n 阶梯数
     * @return 方法数
     */
    public static int goUpstairsRec(int n) {
        if (n <= 2) return n;
        return goUpstairsRec(n - 1) + goUpstairsRec(n - 2);
    }

    /**
     * 求上阶梯的方法数（非递归方式）
     * @param n 阶梯数
     * @return 方法数
     */
    public static int goUpstairs(int n) {
        if (n <= 2) return n;

        int n1 = 1; // 前2个数
        int n2 = 2; // 前1个数
        int current = 0;
        for (int i = 2; i < n; i++) {
            current = n1 + n2;
            n1 = n2;
            n2 = current;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(goUpstairsRec(5));
        System.out.println(goUpstairs(5));
    }
}
