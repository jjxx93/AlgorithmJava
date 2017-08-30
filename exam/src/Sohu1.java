import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Kolakoski序列
 */

public class Sohu1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int a[] = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }

        int[] result = new int[n];
        int i = 0;

        for (; i < a[0] && i < n; i++) {
            result[i] = a[0];
        }

        int aIndex = 1;
        if (aIndex == a.length) aIndex = 0;

        int numIndex = 1;
        if (i < n) {
            if (a[0] == 1) {
                for (; i < a[0] + a[aIndex] && i < n; i++) {
                    result[i] = a[aIndex];
                }
            } else {
                for (; i < a[0] + result[numIndex] && i < n; i++) {
                    result[i] = a[aIndex];
                }
            }
            numIndex++;

            aIndex++;
            if (aIndex == a.length) aIndex = 0;
        }

        while (i < n) {
            for (int j = 0; j < result[numIndex] && i < n; i++, j++) {
                result[i] = a[aIndex];
            }

            numIndex++;
            aIndex++;
            if (aIndex == a.length) aIndex = 0;
        }

        for (int in : result) {
            System.out.println(in);
        }
    }
}
