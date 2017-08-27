package Didi;

import java.util.Scanner;

public class Didi02 {
    public static int getMaxSumOfSubarray(int[] array) {
        if (array == null || array.length == 0) return 0;

//        int maxSum = 0, tempSum = 0;
//        for (int anArray : array) {
//            if (tempSum < 0) tempSum = anArray;
//            else tempSum += anArray;
//
//            if (tempSum > maxSum) maxSum = tempSum;
//        }
//
//        return maxSum;

        int curSum = 0, maxSum = 0x80000000;
        for (int anArray : array) {
            if (curSum <= 0) {
                curSum = anArray;
            } else {
                curSum += anArray;
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayString = scanner.nextLine().split(" ");

        //list排序
        int[] nums = new int[arrayString.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(arrayString[i]);
        }

        System.out.println(getMaxSumOfSubarray(nums));
    }
}

/*
-23 17 -7 11 -2 1 -34
 */
