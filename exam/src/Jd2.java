package exam;

import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/4/7.
 */
public class Jd2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int result;
        if (n <= k) {
            result = 0;
        }
        if (k <= 0) {
            k = 1;
        }
        int p = n / (2 * k + 1);
        int q = n % (2 * k + 1);

        if (q < k) {
            result = 2 * p;
        } else {
            result = 2 * p + 1;
        }
        System.out.print(result);
    }
}
