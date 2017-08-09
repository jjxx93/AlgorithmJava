package tree;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/4/7.
 */

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] v = new int[m];
        int result = 0, price = 0;

        for (int i = 0; i < m; i++) {
            v[i] = scanner.nextInt();
        }
        Arrays.sort(v);

        for (int i = 0; i < m; i++) {
            int temp = n < m - i ? n * v[i] : (m - i) * v[i];
            if (temp > result) {
                price = v[i];
                result = temp;
            }
        }
        System.out.println(price);
    }
}
