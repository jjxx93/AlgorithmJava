package Huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xiongjiaxin on 2017/6/23.
 */
public class Huawei1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strIn = scanner.nextLine();

        ArrayList<Character> lowCases = new ArrayList<Character>();
        ArrayList<Character> highCases = new ArrayList<>();
        ArrayList<Character> nums = new ArrayList<>();

        for (int i = 0; i < strIn.length(); i++) {
            if (strIn.charAt(i) < 58) nums.add(strIn.charAt(i));
            else if (strIn.charAt(i) < 91) highCases.add(strIn.charAt(i));
            else lowCases.add(strIn.charAt(i));
        }

        Character[] lowCaseArray = new Character[lowCases.size()];
        lowCases.toArray(lowCaseArray);
        Character[] highCaseArray = new Character[highCases.size()];
        highCases.toArray(highCaseArray);
        Character[] numsArray = new Character[nums.size()];
        nums.toArray(numsArray);

        Arrays.sort(lowCaseArray);
        Arrays.sort(highCaseArray);
        Arrays.sort(numsArray);

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : lowCaseArray) {
            stringBuilder.append(character);
        }
        for (Character character : highCaseArray) {
            stringBuilder.append(character);
        }
        for (Character character : numsArray) {
            stringBuilder.append(character);
        }

        System.out.println(stringBuilder.toString());
    }
}
