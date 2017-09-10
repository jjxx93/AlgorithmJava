package offer;

/**
 * 输入一个整数n，请你输出斐波那契数列的第n项。
 * Created by jiax on 2017/1/6.
 */
public class _09_Fibonacci {
    public int Fibonacci(int n) {
        int n0 = 0, n1 = 1;
        while (n-- > 0) {
            n1 += n0;
            n0 = n1 - n0;
        }
        return n0;
    }

    public static void main(String[] args) {
        _09_Fibonacci solution5 = new _09_Fibonacci();
        System.out.println(new _09_Fibonacci().Fibonacci(1));
        int[] ints = new int[39];
        for (int i = 0; i < 39; i++) {
            ints[i] = solution5.Fibonacci(i+1);
        }
        for (int in:ints) {
            System.out.print(in+", ");
        }
    }
}
