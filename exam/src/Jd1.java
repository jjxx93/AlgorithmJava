package exam;

import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/4/7.
 */
public class Jd1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String str3 = scanner.nextLine();

        int n = Integer.valueOf(str1);
        char[] chars1 = str2.toCharArray();
        char[] chars2 = str3.toCharArray();

        long result = 0;
        for (int i = 0; i < n; i++) {
            if (chars1[i] != chars2[i]) result += Math.pow(2, n - 1 - i);
        }
        System.out.println(result);
    }
}
