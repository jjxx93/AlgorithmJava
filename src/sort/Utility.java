package sort;

import java.util.Scanner;

/**
 * 工具类
 * Created by jiax on 2016/7/5.
 */
public class Utility {
    public static int[] getIntArr() {
        Scanner sc = new Scanner(System.in);
        String strIn = sc.nextLine();
        sc.close();

        String[] strArr = strIn.split(" ");
        int[] intArr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.valueOf(strArr[i]);
        }

        return intArr;
    }

    /**
     * 调用数组中的两个数
     * @param intArr 数组
     * @param i 调换数1
     * @param j 调换数2
     */
    public static void swap (int[] intArr, int i, int j){
        int temp = intArr[i];
        intArr[i] = intArr[j];
        intArr[j] = temp;
    }

    public static void showIntArr(int[] intArr) {
        for (int i = 0; i < intArr.length - 1; i++) {
            System.out.print(intArr[i] + " ");
        }
        System.out.println(intArr[intArr.length - 1]);
    }
}
