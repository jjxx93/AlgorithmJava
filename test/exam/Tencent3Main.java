package exam;

import java.util.Scanner;

/**
 * abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkl
 * Created by jjxx9 on 2017/4/3.
 */
public class Tencent3Main {
    int function(String str) {
        if (str.length() < 2) return 0;
        int out = 0, numA = 0, numB = 0, numC = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A') out += numA;
            else if (str.charAt(i) == 'B') {
                out += numB;
                numA++;
            } else if (str.charAt(i) == 'C') {
                out += numC;
                numA++;
                numB++;
            } else {
                numA++;
                numB++;
                numC++;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strIn = scanner.nextLine();
        int length = strIn.length();
        int n = length / 16;
        for (int i = 0; i < n; i++) {
            StringBuilder strOut = new StringBuilder();
            String numStr = String.valueOf(i);
            for (int j = 0; j < 7 - numStr.length(); j++) {
                strOut.append(0);
            }
            strOut.append(numStr);
            strOut.append("0  ");
            String subStr = strIn.substring(16*i, 16*(i + 1));
            for (int j = 0; j < 16; j++) {
                int num = subStr.codePointAt(j);
                strOut.append(Integer.toHexString(num));
                if (j == 7) strOut.append("  ");
                else strOut.append(" ");
            }
            strOut.append(" ");
            strOut.append(subStr);
            if (i == n - 1) System.out.print(strOut.toString());
            else System.out.println(strOut.toString());
        }
    }
}
