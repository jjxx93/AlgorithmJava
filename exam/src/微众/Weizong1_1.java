package 微众;

import java.util.Scanner;

/**
 * 给出三个整数a，b，c，你需要计算数2a+2b-2c在二进制表示下1的个数。
 * Created by jjxx9 on 2017/9/28.
 */
public class Weizong1_1 {
    static int getCountOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        System.out.println();
    }
}
