package sort;

/**
 * 从前往后比较，先排好前面的数，再把后来的数插在前面的数列中
 * 或者说：
 * 在第i趟，将位置i上的元素向左移动，直到此元素找到在前i+1位中正确的位置。
 * Created by jiax on 2016/7/5.
 */
public class Insert {
    public static void insertSort(int[] intArr) {
        for (int i = 1; i < intArr.length; i++) {
            int temp = intArr[i];
            int j = i;
            while (j > 0 && temp < intArr[j-1]) {
                intArr[j] = intArr[--j];
            }
            intArr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] intArr = Utility.getIntArr();

        insertSort(intArr);

        Utility.showIntArr(intArr);
    }
}
