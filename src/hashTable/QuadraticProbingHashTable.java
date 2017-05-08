package hashTable;

/**
 * 使用二次探测法实现的哈希表
 * Created by jjxx9 on 2017/3/18.
 */
public class QuadraticProbingHashTable <T> {
    private static class HashEntry<T> {
        T element;
        boolean isActive;

        HashEntry(T x) {
            this(x, true);
        }

        HashEntry(T x, boolean i) {
            this.element = x;
            this.isActive = i;
        }
    }

    private static final int DEFAULT_TABLE_SIZE = 11;
    private HashEntry<T> [] array;
    private int currentSize;

    /**
     * 无参构造函数
     */
    public QuadraticProbingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * 构造最小空间为size的哈希表
     * @param size 最小空间
     */
    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
    }

    /**
     * 检查散列表中是否含有x
     * @param x 待检查元素
     * @return 是否含有
     */
    public boolean contains(T x) {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }

    /**
     * 插入新值x
     * @param x 待插入值
     */
    public void insert(T x) {
        int currentPos = findPos(x);
        if (isActive(currentPos)) return;

        array[currentPos] = new HashEntry<T>(x);

        if (currentSize > array.length/2) reHash();
    }

    /**
     * 从哈希表中删除值
     * @param x 待删除值
     */
    public void remove(T x) {
        int currentSize = findPos(x);
        if (isActive(currentSize)) array[currentSize].isActive = false;
    }

    /**
     * 再哈希
     */
    private void reHash() {
        HashEntry<T>[] oldArray = array;

        allocateArray(2 * oldArray.length);

        currentSize = 0;                    // 在新列表中插入元素
        for (HashEntry<T> entry : oldArray) {
            if (entry != null && entry.isActive) insert(entry.element);
        }
    }

    /**
     * 检查某位置的单元是否有效
     * @param currentPos 单元位置
     * @return 是否有效
     */
    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }

    /**
     * 使用二次探测查找关键词的位置
     * @param x 关键词
     * @return 位置
     */
    private int findPos(T x) {
        int offset = 1;
        int currentPos = myHash(x);

        while (array[currentPos] != null && !array[currentPos].element.equals(x)) {
            currentPos += offset;
            offset += 2;
            if (currentPos >= array.length) currentPos -= array.length;
        }

        return currentPos;
    }

    /**
     * 散列表的哈希函数
     * @param x 待散列元素
     * @return 散列值
     */
    private int myHash(T x) {
        int hashVal = x.hashCode();

        hashVal %= array.length;
        if (hashVal < 0 ) hashVal += array.length;

        return hashVal;
    }

    /**
     * 清空数组
     */
    private void makeEmpty() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    /**
     * 给数组分配空间
     * @param size 数组最小空间
     */
    private void allocateArray(int size) {
        array = new HashEntry[nextPrime(size)];
    }

    /**
     * 寻找比n大的最小素数
     * @param n 开始数
     * @return 最小素数
     */
    private int nextPrime(int n) {
        if (n % 2 == 0) n++;

        for (; !isPrime(n); n += 2) ;

        return n;
    }

    /**
     * 检查n是否为素数
     * @param n 待检查数
     * @return n是否为素数
     */
    private boolean isPrime(int n) {
        if (n == 2 || n == 3) return true;          // 2、3是素数
        if (n == 1 || n % 2 == 0) return false;     // 1、偶数不是素数

        for (int i = 3; i*i < n; i++) {             // 检查是否为素数
            if (n % i == 0) return false;
        }

        return true;
    }
}
