package sort;

/**
 * 归并排序:先将数列分成一个个小部分，排序，再将排序后的部分组合在一起
 * Created by jiax on 2016/7/5.
 */
public class Merge {
    /**
     * 合并两个数组
     * @param intArrLeft 左数组
     * @param intArrRight 右数组
     * @param intArr 合并后的数组
     */
    public static void mergeArray(int[] intArrLeft, int[] intArrRight, int[] intArr) {
        int i = 0, j = 0, k = 0;
        while (i < intArrLeft.length && j < intArrRight.length) {
            if (intArrLeft[i] < intArrRight[j]) {
                intArr[k++] = intArrLeft[i++];
            } else {
                intArr[k++] = intArrRight[j++];
            }
        }

        while (i < intArrLeft.length) {
            intArr[k++] = intArrLeft[i++];
        }

        while (j < intArrRight.length) {
            intArr[k++] = intArrRight[j++];
        }
    }

    /**
     * 归并排序
     * @param intArr 待排序数组
     */
    public static void mergeSort(int[] intArr) {
        if ((intArr.length == 2) && (intArr[1] < intArr[0])) {
            int temp = intArr[1];
            intArr[1] = intArr[0];
            intArr[0] = temp;
        }

        if (intArr.length >= 3) {
            int mid = intArr.length / 2;
            int[] intArrLeft = new int[mid];
            int[] intArrRight = new int[intArr.length - mid];

            System.arraycopy(intArr, 0, intArrLeft, 0, mid);
            System.arraycopy(intArr, mid, intArrRight, 0, intArr.length - mid);

            mergeSort(intArrLeft);
            mergeSort(intArrRight);
            mergeArray(intArrLeft, intArrRight, intArr);
        }
    }

    public static void main(String[] args) {
        int[] intArr = Utility.getIntArr();

        mergeSort(intArr);

        Utility.showIntArr(intArr);
    }
}
