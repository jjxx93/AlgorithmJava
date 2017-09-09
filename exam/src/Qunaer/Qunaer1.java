package Qunaer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 熊佳新 on 2017/9/9.
 */
public class Qunaer1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numStrings1 = scanner.nextLine().split(" ");
        String[] numStrings2 = scanner.nextLine().split(" ");

        int[] nums1 = new int[numStrings1.length];
        for (int i = 0; i < numStrings1.length; i++) {
            nums1[i] = Integer.valueOf(numStrings1[i]);
        }

        int[] nums2 = new int[numStrings2.length];
        for (int i = 0; i < numStrings2.length; i++) {
            nums2[i] = Integer.valueOf(numStrings2[i]);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int count = 0;
        int index1 = nums1.length - 1;
        int index2 = nums2.length - 1;
        while (index1 >=0 && index2 >= 0) {
            while (index2 >= 0 && nums2[index2] >= nums1[index1]) {
                index2--;
            }
            if (index2 >= 0) {
                count++;
                index1--;
                index2--;
            }
        }
        
        System.out.println(count);
    }
}
/*
3 1 5
6 2 4
 */