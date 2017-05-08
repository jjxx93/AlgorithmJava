package offer;

/**
 * Created by jjxx9 on 2017/5/5.
 */
public class MaxSumOfSubarray {
    public static int getMaxSumOfSubarray(int[] array) {
        if (array == null || array.length == 0) return 0;

        int maxSum = 0, tempSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (tempSum < 0) tempSum = array[i];
            else tempSum += array[i];

            if (tempSum > maxSum) maxSum = tempSum;
        }

        return maxSum;
    }
}
