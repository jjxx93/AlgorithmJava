package offer;

/**
 * Created by jjxx9 on 2017/5/5.
 */
public class MaxSumOfSubarray_31 {
    public static int getMaxSumOfSubarray(int[] array) {
        if (array == null || array.length == 0) return 0;

        int maxSum = 0x80000000, tempSum = 0;
        for (int anArray : array) {
            if (tempSum < 0) tempSum = anArray;
            else tempSum += anArray;

            if (tempSum > maxSum) maxSum = tempSum;
        }

        return maxSum;
    }

    /**
     * 应用动态规划法
     * f(i), 以i结尾的子数组的最大和
     * f(i) = array[i] , i = 0 / f(i-1)<=0
     *      = f(i-1)+array[i]
     */

    public static int getMaxSumOfSubarrayByDp(int[] array) {
        if (array == null || array.length == 0) return 0;

        int[] f = new int[array.length];
        f[0] = array[0];

        int maxSum = 0;
        for (int i = 1; i < array.length; i++) {
            if (f[i - 1] <= 0) {
                f[i] = array[i];
            } else {
                f[i] = f[i-1] + array[i];
            }

            if (f[i] > maxSum) {
                maxSum = f[i];
            }
        }

        return maxSum;
    }
}
