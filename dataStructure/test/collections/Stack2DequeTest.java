package collections;

import org.junit.Before;
import org.junit.Test;
import stack.Stack2Deque;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by jjxx9 on 2017/4/10.
 */
public class Stack2DequeTest {
    private final Stack2Deque stack2Deque = new Stack2Deque();

    @Before
    public void init() throws Exception {
        System.out.println("INIT");
    }

    @Test
    public void offer() throws Exception {
        stack2Deque.offer(1);
        stack2Deque.offer(2);
        stack2Deque.offer(3);
    }

    @Test
    public void peek() throws Exception {
        try {                           // 测试：从空队列中删除元素
            stack2Deque.peek();
        } catch (Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }

        stack2Deque.offer(1);     // 测试：往空队列中插入、删除元素
        assertEquals(stack2Deque.peek(), 1);

        stack2Deque.offer(2);     // 测试：连续删除元素直到队列空
        stack2Deque.offer(3);
        stack2Deque.offer(4);
        stack2Deque.offer(5);
        assertEquals(stack2Deque.peek(), 2);
        assertEquals(stack2Deque.peek(), 3);
        assertEquals(stack2Deque.peek(), 4);
        assertEquals(stack2Deque.peek(), 5);
    }

}