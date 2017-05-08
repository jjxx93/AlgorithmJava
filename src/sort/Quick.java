package sort;

/**
 * Created by jiax on 2016/7/6.
 * 先从数列中选出一个标准值，然后将比它小的数放在它左边，
 * 比它大的数放在右边，再按同样的方法分别给左右边的数排序，用递归解决
 */
public class Quick {
    public static void quickSort(int[] intArr, int startIndex, int endIndex) {
        int i = startIndex, j = endIndex;
        int baseNum = intArr[startIndex];
        int baseIndex = startIndex;

        while (i < j) {
            while (intArr[j] >= baseNum && j > i) j--;
             if (j > i) {
                Utility.swap(intArr, j, baseIndex);
                baseIndex = j;

                while (intArr[i] <= baseNum && i < j) i++;
                if (i < j) {
                    Utility.swap(intArr, i, baseIndex);
                    baseIndex = i;
                }
            }
        }

        if (startIndex + 1 < i) quickSort(intArr, startIndex, i - 1);
        if (j + 1 < endIndex) quickSort(intArr, j + 1, endIndex);
    }

    public static void main(String[] args) {
        int[] intArr = Utility.getIntArr();

        quickSort(intArr, 0, intArr.length - 1);

        Utility.showIntArr(intArr);
    }
}
