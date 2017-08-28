package hashTable;

import org.junit.Test;
import stack.SeparateChainingHashTable;

/**
 * Created by jjxx9 on 2017/3/17.
 */
public class SeparateChainingHashTableTest {
    private SeparateChainingHashTable<String> stringSeparateChainingHashTable;

    {
        stringSeparateChainingHashTable = new SeparateChainingHashTable<>(10);
        stringSeparateChainingHashTable.insert("123");
    }

    @Test
    public void insert() throws Exception {
        stringSeparateChainingHashTable.insert("456");
    }

    @Test
    public void contains() throws Exception {
        System.out.println(stringSeparateChainingHashTable.contains("12"));
        System.out.println(stringSeparateChainingHashTable.contains("123"));
    }

    @Test
    public void makeEmpty() throws Exception {
        System.out.println(stringSeparateChainingHashTable.contains("123"));
        stringSeparateChainingHashTable.makeEmpty();
        System.out.println(stringSeparateChainingHashTable.contains("123"));
    }

    @Test
    public void remove() throws Exception {
        System.out.println(stringSeparateChainingHashTable.contains("123"));
        stringSeparateChainingHashTable.remove("123");
        System.out.println(stringSeparateChainingHashTable.contains("123"));
    }
}