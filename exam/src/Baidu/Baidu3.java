package Baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jjxx9 on 2017/4/27.
 */
public class Baidu3 {
    public static int total = 0;
    public static List<int[]> intList = new ArrayList<>();

    public static void permute(int[] array,int start) {
        if(start == array.length) {  // 输出
            System.out.println(Arrays.toString(array));
            intList.add(array.clone());
            total++;
        } else {
            for (int i = start; i < array.length; ++i) {
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

