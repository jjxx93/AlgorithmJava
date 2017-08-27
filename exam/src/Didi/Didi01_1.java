package Didi;

import java.util.*;

public class Didi01_1 {
    public static int findKMaxNumsByBigTopPile(int[] nums, int k) {
        if (nums == null || nums.length <= k) return 0;

        // 小顶堆
        TreeSet<Integer> minNums = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            minNums.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minNums.first()) {
                minNums.pollFirst();
                minNums.add(nums[i]);
            }
        }

        return minNums.pollFirst();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] temp = scanner.nextLine().split(" ");

        int size = temp.length;
        int[] dateArray = new int[size];
        for (int i = 0; i < size; i++) {
            dateArray[i]=Integer.valueOf(temp[i]);
        }
        int k = scanner.nextInt();
        int result = findKMaxNumsByBigTopPile(dateArray, k);

        System.out.println(result);


    }
}