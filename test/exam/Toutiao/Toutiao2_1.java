package exam.Toutiao;

import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/4/18.
 */
public class Toutiao2_1 {
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

    public static int[] quickSort(int[] intArr, int startIndex, int endIndex) {
        int i = startIndex, j = endIndex;
        int baseNum = intArr[startIndex];
        int baseIndex = startIndex;

        while (i < j) {
            while (intArr[j] >= baseNum && j > i) j--;
            if (j > i) {
                swap(intArr, j, baseIndex);
                baseIndex = j;

                while (intArr[i] <= baseNum && i < j) i++;
                if (i < j) {
                    swap(intArr, i, baseIndex);
                    baseIndex = i;
                }
            }
        }

        if (startIndex + 1 < i) quickSort(intArr, startIndex, i - 1);
        if (j + 1 < endIndex) quickSort(intArr, j + 1, endIndex);
        return intArr;
    }

    /**
     * 二分查找
     * @param array 数组
     * @param a 待查找数
     * @return 位置
     */
    public static int binarySearch(int[] array,int a){
        int lo = 0;
        int hi = array.length-1;
        int mid;
        while (lo <= hi) {
            mid = (lo+hi)/2;
            if(array[mid] == a) {
                return mid + 1;
            } else if(array[mid] < a){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

//        Arrays.sort(nums);  // 排序
        nums = quickSort(nums, 0, nums.length - 1);
        int k = scanner.nextInt();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            int temp = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                if (binarySearch(nums, temp) != -1) {
                    stringBuilder.append(temp);
                    stringBuilder.append(' ');
                    break;
                }
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            System.out.print(stringBuilder.toString());
        }
    }
}
/*
5
11
15
9
12
3
4
11
3
9
7
 */
