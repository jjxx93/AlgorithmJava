package offer;

import org.junit.Test;

/**
 * Created by jjxx9 on 2017/5/2.
 */
public class MinStackTest {
    @Test
    public void push() throws Exception {
        MinStack minStack = new MinStack();
//        minStack.push(1);
//        minStack.push(2);
//        minStack.push(3);
//        assertEquals(1, minStack.min());
//        assertEquals(3, minStack.pop());

        minStack.push(3);
        minStack.push(2);
        minStack.push(1);
        assertEquals(1, minStack.min());
        assertEquals(1, minStack.pop());
    }

    @Test
    public void pop() throws Exception {
    }

    @Test
    public void min() throws Exception {
    }

}