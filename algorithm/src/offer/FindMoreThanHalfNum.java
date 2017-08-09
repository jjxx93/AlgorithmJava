package offer;

import static sort.Utility.swap;

/**
 * 找出数组中出现次数超过一半的数字
 * Created by jjxx9 on 2017/5/5.
 */
public class FindMoreThanHalfNum {
    public static int findMoreThanHalfNum(int[] nums) {
        int start = 0, end = nums.length - 1;
        int index = partition(nums, 0, nums.length - 1);
        int middle = nums.length / 2;

        while (index != middle) {
            if (index < middle) start = index + 1;
            else end = end - 1;
            index = partition(nums, start, end);
        }

        return nums[index];
    }

    public static int partition(int[] nums, int start, int end) {
        int left = start, right = end, base = start;
        int baseNum = nums[start];

        while (left <= right) {
            while (nums[right] >= baseNum && left <= right) right--;
            if (left <= right) {
                swap(nums, base, right);
                base = right;

                while (nums[left] <= baseNum && left <= right) left++;
                if (left <= right) {
                    swap(nums, start, end);
                    base = left;
                }
            }
        }

        return base;
    }


}
