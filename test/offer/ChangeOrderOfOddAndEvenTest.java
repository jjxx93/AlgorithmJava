package offer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jjxx9 on 2017/4/13.
 */
public class ChangeOrderOfOddAndEvenTest {
    @Test
    public void changeOrder() throws Exception {
        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] out1 = ChangeOrderOfOddAndEven.changeOrder(test1);
        for (int i = 0; i < out1.length; i++) {
            System.out.print(out1[i] + " ");
        }

        int[] test2 = {1};
        int[] out2 = ChangeOrderOfOddAndEven.changeOrder(test2);
        for (int i = 0; i < out2.length; i++) {
            System.out.print(out2[i] + " ");
        }

        ChangeOrderOfOddAndEven.changeOrder(null);
    }

}