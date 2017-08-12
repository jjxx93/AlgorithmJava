package wangyi;

import java.util.Scanner;

/**
 * Created by xiongjiaxin on 2017/8/12.
 *
 * 3 5 100 10
 */
public class Wangyi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int f = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        sc.close();

        int t = d / x;
        if (t <= f) {
            System.out.println(t);
        } else {
            t = (d + f * p) / (p + x);
            System.out.println(t);
        }
    }
}
