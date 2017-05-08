package sort;

/**
 * 泡沫排序
 * 从前往后比较相邻节点，将较大值放在最后.然后再对未排序的序列从前往后比较相邻节点，将较大值放在最后。
 * Created by jiax on 2016/7/5.
 */
public class Bubble {
    public static void bubbleSort(int[] intArr) {
        for (int i = 0; i < intArr.length - 1; i++) {
            for (int j = 0; j < intArr.length - i - 1; j++) {
                if (intArr[j+1] < intArr[j]) {
                    Utility.swap(intArr, j, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] intArr = Utility.getIntArr();

        bubbleSort(intArr);

        Utility.showIntArr(intArr);
    }
}
