package offer;

import sort.Utility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

/**
 * 从一个无序数组中找出k个最小的数
 * Created by jjxx9 on 2017/5/5.
 */
public class FindKMinimumNums_30 {
    public static int[] findKMinNumsByBigTopPile(int[] nums, int k) {
        if (nums.length < k) return null;
        if (nums.length == k) return nums;

        // 大顶堆
        TreeSet<Integer> minNums = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return (num1 > num2) ? -1 : ((Objects.equals(num1, num2)) ? 0 : 1);
            }
        });

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

    public static int[] findKMinNumsByQuickSort(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;

        int start = 0, end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != k) {
            if (index > k) {
                end = index - 1;
                index = partition(nums, start, end);
            } else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }

        int[] result = new int[k];
        System.arraycopy(nums, 0, result, 0, k);

        return result;
    }

    public static int partition(int[] nums, int start, int end) {
        if (start >= end) return start;

        int index = start, i = start, j = end;
        while (i < j) {
            while (nums[index] < nums[j]) j--;
            if (i < j) {
                Utility.swap(nums, j, index);
                index = j;

                while (nums[index] > nums[i]) i++;
                if (i < j) {
                    Utility.swap(nums, i, index);
                    index = i;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findKMinNumsByQuickSort(new int[]{1, 5, 2}, 2)));
    }
}
