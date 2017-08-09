package Toutiao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/3/30.
 */
public class Toutiao_2 {
    public static void printBracket(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {

        }
        System.out.println("+-+\n"+"||\n"+"\n"+"||\n"+"+-+");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();

        ArrayList<Integer> arrayList = new ArrayList<>();
        int maxLay = 0;
        int startIndex = 0;
        for (int i = 0; i < chars.length; ) {
            if (chars[i] != ']') i++;
            else {
                int lay = i - startIndex;
                i += lay - 1;
                if (lay > maxLay) maxLay = lay;
                arrayList.add(lay);
                System.out.println(lay);
                startIndex = i;
            }
        }

//        int n = chars.length /2;
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i != n; i++) {
//            stringBuilder.append("+-+\n| |\n\n| |\n+-+\n");
//        }
//        stringBuilder.deleteCharAt(stringBuilder.length()-1);
//        System.out.print(stringBuilder.toString());
    }
}
