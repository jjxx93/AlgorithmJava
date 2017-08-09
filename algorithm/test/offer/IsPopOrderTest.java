package offer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jjxx9 on 2017/5/2.
 */
public class IsPopOrderTest {
    @Test
    public void isPopOrder() throws Exception {
        int[] pushArray = {1, 2, 3, 4, 5};
        int[] popArray1 = {4, 5, 3, 2, 1};
        int[] popArray2 = {4, 3, 5, 1, 2};
        boolean result = IsPopOrder.isPopOrder(pushArray, popArray1);
        assertTrue(result);
        result = IsPopOrder.isPopOrder(pushArray, popArray2);
        assertFalse(result);
        System.out.println(IsPopOrder.isPopOrder(new int[]{1, 2, 3}, new int[]{1, 2}));
    }

}