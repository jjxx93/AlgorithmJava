package exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/4/22.
4
5 4
6 4
6 7
2 3
 */
public class DiDi2 {
    /**
     * 使用动态规划计算娃娃最大嵌套层数
     * @param dolls 娃娃的w、l
     * @return 最大嵌套层数
     */
    public static int mostLayerDolls(int[][] dolls) {
        if(dolls == null || dolls.length == 0 || dolls[0] == null || dolls[0].length != 2)
            return 0;

//        Arrays.sort(dolls, (doll1, doll1) -> {
//            return (doll1[0] == doll1[0]) ? (doll1[1] - doll1[1]) : (doll1[0] - doll1[0]);
//        });

        Arrays.sort(dolls, new Comparator<int[]>() {
            public int compare(int[] doll0, int[] doll1) {
                // w相同比较l，w不同比较w
                return (doll0[0] == doll1[0]) ? (doll1[1] - doll0[1]) : (doll0[0] - doll1[0]);
            }
        });

        int len = 0;
        int minL[] = new int[dolls.length];

        for(int[] doll : dolls) {
            int index = Arrays.binarySearch(minL, 0, len, doll[1]);
            if(index < 0) index = -index - 1;
            if(index == len) len++;
            minL[index] = doll[1];
        }

        return len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] dolls = new int[n][2];
        for (int i = 0; i < n; i++) {
            dolls[i][0] = scanner.nextInt();
            dolls[i][1] = scanner.nextInt();
        }

        System.out.println(mostLayerDolls(dolls));
    }
}
