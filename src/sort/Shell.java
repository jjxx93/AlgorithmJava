package sort;

/**
 * 希尔排序
 * Created by jiax on 2016/11/27.
 */
public class Shell {
    public static void shellSort (int[] inArr) {
        for (int gap = inArr.length / 2; gap > 0;  gap /= 2) {        // 步长
            for (int i = 0; i < gap; i ++) {                // 插入排序
                for (int j = i + gap; j < inArr.length; j += gap) {
                    int temp = inArr[j];
                    int k = j - gap;
                    while (k >= 0 && inArr[k] > temp) {
                        inArr[k + gap] = inArr[k];
                        k -= gap;
                    }
                    inArr[k + gap] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] intArr = Utility.getIntArr();

        shellSort(intArr);

        Utility.showIntArr(intArr);
    }
}
