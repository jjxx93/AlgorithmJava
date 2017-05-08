package exam; /**
 * Created by jjxx9 on 2017/4/11.
 */

import java.util.Scanner;

public class XieC_PinTu {
    static int run(int[] order){
        int a, count = 0, m = 0, n = 0;
        int orderCount = 0;

        for (int i = 0; i < 9; i++) {
            if (order[i] == i+1) orderCount++;
            a = order[i];
            if (a == 8) {
                m = i / 3;
                n = i % 3;
            }

            for (int j = i + 1; j < 9; j++) {
                if (order[j] < a) count++;
            }
        }

        count += m;
        count += n;

        if (orderCount == 8) return 0;
        else if (count % 2 == 0) return count / 2;
        else return -1;
    }

//    static int check(int[] order) {
//        int a, count = 0, m = 0, n = 0;
//        int orderCount = 0;
//
//        for (int i = 0; i < 9; i++) {
//            if (order[i] == i+1) orderCount++;
//            a = order[i];
//            if (a == 8) {
//                m = i / 3;
//                n = i % 3;
//            }
//
//            for (int j = i + 1; j < 9; j++) {
//                if (order[j] < a) count++;
//            }
//        }
//
//        count += m;
//        count += n;
//
//        if (orderCount == 8) return 0;
//        else if (count % 2 == 0) return count / 2;
//        else return -1;
//    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = new int[9];
        for (int i = 0; i < 9; i++) {
            numbers[i] = scan.nextInt();
        }

        int res = run(numbers);

        System.out.println(String.valueOf(res));
    }
}
/*
0 1 3
4 2 5
7 8 4
 */
/*
1 2 3
4 5 6
7 8 0
 */