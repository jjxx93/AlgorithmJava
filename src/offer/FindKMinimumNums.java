package offer;

import java.util.TreeSet;

/**
 * 从一个无序数组中找出k个最小的数
 * Created by jjxx9 on 2017/5/5.
 */
public class FindKMinimumNums {
    public static int[] findKMinNums(int[] nums, int k) {
        if (nums.length < k) return null;
        if (nums.length == k) return nums;

        // 大顶堆
        TreeSet<Integer> minNums = new TreeSet<>((num1, num2) -> (num1 > num2) ? -1 : ((num1 == num2) ? 0 : 1));

        for (int i = 0; i < k; i++) {
            minNums.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] < minNums.first()) {
                minNums.pollFirst();
                minNums.add(nums[i]);
            }
        }

        int[] result = new int[k];
        int i = 0;
        for (Integer in : minNums) {
            result[i++] = in;
        }

        return result;
    }
}
