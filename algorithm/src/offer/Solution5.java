package offer;

/**
 * 输入一个整数n，请你输出斐波那契数列的第n项。
 * Created by jiax on 2017/1/6.
 */
public class Solution5 {
    public int Fibonacci(int n) {
        int[] ints = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986};
        int n0 = 0, n1 = 1;
        while (n-- > 0) {
            n1 += n0;
            n0 = n1 - n0;
        }
        return n0;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(new Solution5().Fibonacci(1));
        int[] ints = new int[39];
        for (int i = 0; i < 39; i++) {
            ints[i] = solution5.Fibonacci(i+1);
        }
        for (int in:ints) {
            System.out.print(in+", ");
        }
    }
}
