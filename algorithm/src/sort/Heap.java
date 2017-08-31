package sort;

//import tree.BinaryHeap;

/**
 * 堆排序
 * Created by jjxx9 on 2017/3/23.
 */
public class Heap {
    public static void heapSort(int[] intArr) {
        Integer[] integers = new Integer[intArr.length];
        for (int i = 0; i < intArr.  length; i++) {
            integers[i] = intArr[i];
        }

//        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(integers);
//
//        for (int i = 0; i < intArr.length; i++) {
//            intArr[i] = binaryHeap.deleteMin();
//        }
    }

    public static void main(String[] args) {
        int[] intArr = Utility.getIntArr();

        heapSort(intArr);

        Utility.showIntArr(intArr);
    }
}
