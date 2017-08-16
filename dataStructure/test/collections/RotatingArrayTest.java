package collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jjxx9 on 2017/4/10.
 */
public class RotatingArrayTest {
    private final RotatingArray rotatingArray = new RotatingArray();

    @Test
    public void getMin() throws Exception {
        int[] array1 = {5, 6, 1, 2, 3, 4};
        assertEquals(rotatingArray.getMin(array1), 1);

        int[] array2 = {1, 0, 1, 1, 1, 1};
        assertEquals(rotatingArray.getMin(array2), 0);

        int n = 9, count = 0;
        while (n > 0) {
            if ((n & 1) == 1) count ++;
            n = n >> 1;
        }
        System.out.println(count);
    }
}