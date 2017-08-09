package offer;

/**
 * 把数组中的奇数都移到数组的前半部分，偶数都移到后半部分。
 * Created by jjxx9 on 2017/4/13.
 */
public class ChangeOrderOfOddAndEven {
    /**
     * 把数组中的奇数都移到数组的前半部分，偶数都移到后半部分
     * @param array 待排序数组
     * @return 已排序数组
     */
    public static int[] changeOrder(int[] array) {
        if (array == null || array.length < 2) return array;

        int index1 = 0, index2 = array.length - 1;

        while (index1 < index2) {
            while ((index1 < index2) && (array[index1] % 2 == 1)) index1++;
            while ((index1 < index2) && (array[index2] % 2 == 0)) index2--;

            if (index1 < index2) {
                int temp = array[index1];
                array[index1] = array[index2];
                array[index2] = temp;
            }
        }

        return array;
    }
}
