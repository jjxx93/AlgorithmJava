package tree;

/**
 * 二叉堆
 * Created by jjxx9 on 2017/3/23.
 */
public class BinaryHeap<T extends Comparable> {
    private static int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private T [] array;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (T[]) new Comparable[capacity + 1];
    }

    public BinaryHeap(T[] items) {
        currentSize = items.length;
        array = (T[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

        int i = 1;
        for( T item : items )
            array[ i++ ] = item;
        buildHeap( );
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    /**
     * 下滤
     * @param i
     */
    private void percolateDown(int i) {
        int child;
        T temp = array[i];

        for (; i * 2 <= currentSize; i = child) {
            child = i * 2;
            if (child != currentSize && array[child+1].compareTo(array[child]) < 0) child++;
            if (array[child].compareTo(temp) < 0) array[i] = array[child];
            else break;
        }

        array[i] = temp;
    }

    public T deleteMin() {
        T minItem = array[1];
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }
}
