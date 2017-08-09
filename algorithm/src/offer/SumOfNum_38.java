package offer;

/**
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 * 输入：{1, 2, 3, 3, 3, 3, 4, 5}, 3
 * 输出：4
 * Created by jjxx9 on 2017/5/5.
 */
public class SumOfNum_38 {
    public static int GetNumOfK(int[] nums, int num) {
        if (nums == null || nums.length == 0) return -1;

        int start = getStartIndex(nums, num);
        int end = getEndIndex(nums, num);

        if (start != -1 && end != -1) return end - start + 1;
        else return -1;
    }

    private static int getStartIndex(int[] nums, int num) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == num) {
                if (middle == 0) return middle;
                if (middle > 0 && nums[middle - 1] != num) return middle;
                end = middle - 1;
            } else if (nums[middle] > num) end = middle - 1;
            else start = middle + 1;
        }

        return -1;
    }

    private static int getEndIndex(int[] nums, int num) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == num) {
                if (middle == (nums.length - 1)) return middle;
                if (middle < (nums.length - 1) && nums[middle + 1] != num) return middle;
                start = middle + 1;
            } else if (nums[middle] > num) end = middle - 1;
            else start = middle + 1;
        }

        return -1;
    }
}
