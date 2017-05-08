package exam.Toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/3/30.
 */
public class Toutiao_4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] nq = scanner.nextLine().split(" ");
        String[] AString = scanner.nextLine().split(" ");
        String[] BString = scanner.nextLine().split(" ");

        //整理数据
        int n = Integer.valueOf(nq[0]);
        int q = Integer.valueOf(nq[1]);

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(Integer.valueOf(AString[i]));
        }
        List<Integer> B = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            B.add(Integer.valueOf(BString[i]));
        }

        int[] x = new int[q];
        int[] y = new int[q];
        for (int i = 0; i < q; i++) {
            String[] xy = scanner.nextLine().split(" ");
            x[i] = Integer.valueOf(xy[0]);
            y[i] = Integer.valueOf(xy[1]);
        }


        //对q数组
        for (int i = 0; i < q; i++) {

            //对A,B数组
            int count = 0;
            for (int j = 0; j < n; j++) {

                if (A.get(j) >= x[i] && B.get(j) >= y[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
