package exam;

import java.util.Scanner;

/**
I have a dream!
 * Created by jjxx9 on 2017/4/22.
 */
public class DiDi1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");

        StringBuilder outString = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            outString.append(new StringBuilder(array[i]).reverse());    // 反转单词
            outString.append(' ');
        }
        if (outString.length() > 0) outString.delete(outString.length() - 1, outString.length());
        System.out.println(outString.toString());
    }
}
