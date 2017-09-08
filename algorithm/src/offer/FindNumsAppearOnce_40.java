package offer;

/**
 * Created by 熊佳新 on 2017/9/8.
 *
 * 找出数组中只出现一次的两个数字。
 */
public class FindNumsAppearOnce_40 {
    public static int[] find2Nums(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        int xorResult = nums[0] ^ nums[1];
        for (int i = 2; i < nums.length; i++) {
            xorResult ^= nums[i];
        }

        int indexOf1 = findIndexOf1(xorResult);
        int[] result = new int[2];
        for (int num : nums) {
            if (indexIs1(num, indexOf1)) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }

    private static int findIndexOf1(int xorResult) {
        int index = 0;

        while (xorResult != 0) {
            if ((xorResult & 1) == 0) {
                index++;
            }
            xorResult >>>= 1;
        }

        return index;
    }

    private static boolean indexIs1(int num, int indexOf1) {
        num >>>= indexOf1;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        FindNumsAppearOnce_40.find2Nums(new int[]{1, 1, 2, 3, 4, 4});
    }
}
