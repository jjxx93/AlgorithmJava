package 微众;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/4/25.
 */
public class Weizong2 {
//    public static boolean hasSame(int[][] ob1, int index) {
//        for (int i = 0; i < ob1.length; i++) {
//            if (i != index) {
//                if (hasSame(ob1[i], ob1[index])) break;
//            }
//        }
//
//        if ()
//    }

    public static boolean hasSame(int[] ob1, int[] ob2) {
        if (ob1[0] == ob2[0] && ob1[1] == ob2[1]) return true;
        return false;
    }

    public static boolean checkLine(int[] line, int startIndex) {
        if (line[startIndex] != line[startIndex + 2] && line[startIndex + 1] != line[startIndex + 3]) return false;
        // 不平行于坐标轴
        if (line[startIndex] == line[startIndex + 1] && line[startIndex + 1] == line[startIndex + 2]
                && line[startIndex + 2] == line[startIndex + 3]) return false;
        // 不是线段

        return true;
    }

    public static boolean isRectangle(int[] lineCoordinates) {
//        if (checkLine(lineCoordinates, 0) < 0 || checkLine(lineCoordinates, 4) < 0 ||
//                checkLine(lineCoordinates, 8) < 0 || checkLine(lineCoordinates, 12) < 0)
//            return false;

        if (!checkLine(lineCoordinates, 0) || !checkLine(lineCoordinates, 4) ||
                !checkLine(lineCoordinates, 8) || !checkLine(lineCoordinates, 12)) {
            return false;
        }


        int[][] coordinates = new int[8][2];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 2; j++) {
                coordinates[i][j] = lineCoordinates[i * 2 + j];
            }
        }

        boolean result = true;
        for (int i = 0; i < 8; i++) {
            int j = 0, k = 0;
            for (; j < 8; j++) {
                if (i != j) {
                    if (hasSame(coordinates[i], coordinates[j])) break;
                }
                k++;
            }
            if (k == 8) return false;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<int[]> arrayList = new ArrayList<>();
        //while (scanner.hasNext()) {
            int[] lineCoordinates = new int[16];

            for (int i = 0; i < 16; i++) {
                lineCoordinates[i] = scanner.nextInt();
            }

            System.out.println(isRectangle(lineCoordinates));

            arrayList.add(lineCoordinates);
        //}

//        if (arrayList.isEmpty()) return;
//        for(int[] nums : arrayList) {
//            if (isRectangle(nums)) System.out.println("YES");
//            else System.out.println("NO");
//        }
    }
}
/*
1 1 6 1
1 0 6 0
6 0 6 1
1 1 1 0

0 0 0 3
2 0 0 0
2 2 2 0
0 2 2 2
 */