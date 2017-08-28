package stack;

/**
 * 求旋转数组的最小数字
 * 如{3, 4, 5, 1, 2}是{1, 2, 3, 4, 5}的一个旋转，其中旋转数组是{1, 2}，则旋转数组的最小数是1
 * Created by jjxx9 on 2017/4/10.
 */
public class RotatingArray {
    public int getMin(int[] array) {
        if (array == null || array.length == 0) throw new RuntimeException("Invalid array!");

        int index1 = 0, index2 = array.length - 1;
        int indexMid = index1;

        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }

            indexMid = (index1 + index2) / 2;

            // 数组中元素相同
            if (array[index1] == array[index2] && array[index1] == array[indexMid])
                return getMinInOrder(array, index1, index2);    // 顺序查找

            // 二分查找
            if (array[indexMid] >= array[index2]) index1 = indexMid;
            else if (array[indexMid] <= array[index2]) index2 = indexMid;
        }

        return array[indexMid];
    }

    /**
     * 顺序查找数组中某段的最小值
     * @param array 数组
     * @param index1 查找头
     * @param index2 查找尾
     * @return 最小值
     */
    private int getMinInOrder(int[] array, int index1, int index2) {
        int result = array[index1];
        for (int i = index1 + 1; i < index2; i++) {
            if (result > array[i]) result = array[i];
        }
        return result;
    }
}
