package sort;

/**
 * 选择排序
 * 找出未排序序列的最小值，放在未排序序列的最前面
 * Created by jiax on 2016/7/5.
 */
public class Select {
    public static void selectSort(int[] intArr) {
        for (int i = 0; i < intArr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[j] < intArr[minIndex]) minIndex = j;
            }
            Utility.swap(intArr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] intArr = Utility.getIntArr();

        selectSort(intArr);

        Utility.showIntArr(intArr);
    }
}
