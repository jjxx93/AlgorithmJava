package 盛大;

import java.util.Scanner;

/**
 * Created by 熊佳新 on 2017/9/10.
 */
public class Shengda1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(",");
        if (strings.length == 1 || strings[0].length() != 5) {
            System.out.println("error");
            return;
        }
        int n = scanner.nextInt() - 1;

        char[] limitNums = {'1', '9', '2', '8', '3', '7', '4', '6', '5', '0'};
        StringBuilder sbOut = new StringBuilder();
        for (String string : strings) {
            if (string.length() != 5) {
                System.out.println("error");
                return;
            }

            if (n < 6) {
                for (int i = 4; i >= 0; i--) {
                    char cha = string.charAt(i);
                    if (i == 0 && !Character.isDigit(cha)) {
                        System.out.println("error");
                        return;
                    }
                    if (Character.isDigit(cha)) {
                        if (cha == limitNums[2 * n] ||
                            cha == limitNums[2 * n + 1]) {
                            sbOut.append(string);
                            sbOut.append(',');
                        }
                        break;
                    }
                }
            }
        }

        if (sbOut.length() == 0) {
            System.out.println("none");
        } else {
            System.out.println(sbOut.substring(0, sbOut.length() - 1));
        }
    }
}
