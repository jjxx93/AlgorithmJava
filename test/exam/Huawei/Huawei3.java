package exam.Huawei;

import java.util.Scanner;

/**
 * 任意进制转换
 * Created by xiongjiaxin on 2017/6/23.
 */
public class Huawei3 {
    private static char[] NUMS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static int toTenRadix(int num, int sourceRadix) {
        int ten = 0;
        int pow = 1;
        while (num > 0) {
            int bit = num % 10;
            num = num / 10;
            ten += bit * pow;
            pow *= sourceRadix;
        }

        return ten;
    }

    private static String toNRadix(int num, int targetRadix) {
        StringBuilder stringBuilder = new StringBuilder();

        while (num > 0) {
            int i = num % targetRadix;
            stringBuilder.append(NUMS[i]);

            num /= targetRadix;
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sourceRadix = scanner.nextInt();
        int targetRadix = scanner.nextInt();
        int inNum = scanner.nextInt();

        int tenNum = toTenRadix(inNum, sourceRadix);
        String out = toNRadix(tenNum, targetRadix);
        System.out.println(out);
    }
}
