package offer;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * Created by xiongjiaxin on 2017/8/2.
 */
public class DuplicateNum {
    /**
     *
     * @param nums an array of integers
     * @param length the length of array numbers
     * @param duplication 返回任意重复的一个，赋值duplication[0]
     * @return
     */
    private static boolean findDuplicateNum(int[] nums, int length, int [] duplication) {
        if (nums == null || length == 0) return false;

        for (int index = 0; index < length; index++) {
            while(nums[index] != index) {
                if (nums[index] == nums[nums[index]]) {   // 找到相同值
                    duplication[0] = nums[index];
                    return true;
                }

                // 交换nums[index]与nums[nums[index]]
                int tempNum = nums[index];
                nums[index] = nums[tempNum];
                nums[tempNum] = tempNum;
            }
        }

        return false;
    }
}
