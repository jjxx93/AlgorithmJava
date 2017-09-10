package offer;

/**
 * Created by 熊佳新 on 2017/9/10.
 */
public class _08_MinNumInRotateArray {
    static int findMinNum(int[] intNums) {
        int startIndex = 0, endIndex = intNums.length - 1;
        int midIndex = 0;
        while (startIndex <= endIndex) {
            if (endIndex - startIndex == 1) {
                return intNums[endIndex];
            }

            midIndex = (startIndex + endIndex) / 2;
            if (intNums[midIndex] >= intNums[startIndex]) {
                startIndex = midIndex;
            } else if (intNums[midIndex] <= intNums[endIndex]) {
                endIndex = midIndex;
            }
        }

        return intNums[midIndex];
    }

    public static void main(String[] args) {
        System.out.println(_08_MinNumInRotateArray.findMinNum(new int[]{3, 4, 5, 1, 2}));
    }
}
