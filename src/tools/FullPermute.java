package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列
 * Created by jjxx9 on 2017/4/27.
 */
public class FullPermute {
    public static double[] zuhe;   //其中N名评委的打分数组
    public static List Cmn = new ArrayList(); //Cmn，从M中取N名评委时，打分组合


    public static int total = 0;
    public static List<int[]> intList = new ArrayList<>();

    public static void permute(int[] array,int start) {
        if(start == array.length) {  // 输出
            intList.add(array.clone());
            total++;
        } else {
            for (int i = start; i < array.length; ++i) {    //第i个数分别与它后面的数字交换就能得到新的排列
                swap(array, start, i);  //  交换元素
                permute(array, start + 1);  //交换后，再进行全排列算法
                swap(array, start, i);  //还原成原来的数组，便于下一次的全排列
            }
        }
    }

    private static void swap(int[] array,int s,int i) {
        int t = array[s];
        array[s] = array[i];
        array[i] = t;
    }



    public static void main(String[] args) {
        int ints[] = {1, 2, 3};
        permute(ints, 0);
//        List<int[]> result = arrange(ints, 0, ints.length);
        for(int[] in : intList) {
            for (int num : in) System.out.print(num + " ");
            System.out.println();
        }
        System.out.println(total);
    }
}
