package offer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jjxx9 on 2017/5/5.
 */
public class FindKMinimumNumsTest {
    @Test
    public void findKMinNums() throws Exception {
        int[] test = {3, 4, 5, 6, 2, 1, 0, 10, 11};
        int[] result = FindKMinimumNums.findKMinNums(test, 4);

        for (int in : result) {
            System.out.print(in + " ");
        }
    }

}