package stack;

import java.util.LinkedList;
import java.util.List;

/**
 * 使用分离链表法实现的哈希表
 * Created by jjxx9 on 2017/3/17.
 */
public class SeparateChainingHashTable<T> {
    private static final int DEFAULT_TABLE_SIZE = 101;

    private List<T> [] theLists;
    private int currentSize;

    /**
     * 无参构造函数
     */
    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * 构造容量最小为size的哈希表
     * @param size 最小容量
     */
    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<T>();
        }
    }

    /**
     * 插入一个元素x到哈希表中
     * @param x 待插入元素
     */
    public void insert(T x) {
        if (contains(x)) return;        // 该元素已存在

        List<T> whichList = theLists[myHash(x)];    // 找到待插入位置
        whichList.add(x);

        if (++currentSize > theLists.length) reHash();  // 表实际元素数量超过了表大小，再散列
    }

    /**
     * 检查哈希表中是否含有元素x
     * @param x 待查元素
     * @return 希表中是否含有元素x
     */
    public boolean contains(T x) {
        List<T> whichList = theLists[myHash(x)];
        return whichList.contains(x);
    }

    /**
     * 清空此哈希表
     */
    public void makeEmpty() {
        for (int i = 0; i < theLists.length; i++) {
            theLists[i].clear();
        }

        currentSize = 0;
    }

    /**
     * 删除某元素x
     * @param x 待删除元素
     * @return 是否删除成功
     */
    public boolean remove(T x) {
        if (!contains(x)) return true;

        currentSize--;
        return theLists[myHash(x)].remove(x);
    }

    /**
     * 散列表的哈希函数
     * @param x 待散列元素
     * @return 散列值
     */
    private int myHash(T x) {
        int hashVal = x.hashCode();

        hashVal %= theLists.length;
        if (hashVal < 0 ) hashVal += theLists.length;

        return hashVal;
    }

    /**
     * 再散列
     */
    private void reHash() {
        List<T>[] oldList = theLists;

        theLists = new List[nextPrime(2* theLists.length)];     // 扩容两倍
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }

        currentSize = 0;                    // 在新列表中插入元素
        for (List<T> list : oldList) {
            for (T item : list) insert(item);
        }
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
