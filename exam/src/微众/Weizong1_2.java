package 微众;

import java.util.Scanner;

/**
 * 给出一个非负整数 n，我们可以用各种进制来表示它。比如说数 23，它在十进制表示下就是 23，在二进制表示下是 10111，在八进制表示下是 27，在十二进制表示下 1B(B 表示 11)。 n 在某种进制表示下的权值为将其各位数字相加的和，比如 23 在二进制表示下的权值为1+0+1+1+1=4，23 在八进制表示下的权值为 2+7=9，23 在十二进制表示下的权值为1+11=12。

 现在给出一个非负整数n，你可以用p进制去表示它(2 ≤p≤n )，同时你要使得它在这种进制表示下的权值最大。
 * Created by jjxx9 on 2017/9/28.
 */
public class Weizong1_2 {
    static int count(int n, int base) {
        int result = 0;
        while (n > 0) {
            result += n % base;
            n /= base;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int max = 0;
        int mid = n / 2 + 1;
        for (int i = 2; i <= mid; i++) {
            int result = count(n, i);
            if (result > max) {
                max = result;
            }
        }

        System.out.println(max);
    }
}
