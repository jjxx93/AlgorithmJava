package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * 使用两个栈组成一个队列
 * Created by jjxx9 on 2017/4/10.
 */
public class Stack2Deque {
    private Deque<Integer> stackIn;
    private Deque<Integer> stackOut;

    public Stack2Deque() {
        this.stackIn  = new ArrayDeque<>();
        this.stackOut = new ArrayDeque<>();
    }

    /**
     * 插入数据到队头
     * @param value 新值
     */
    public void offer(int value) {
        stackIn.push(value);
    }

    /**
     * 从队尾取出数据
     * @return 队尾值
     */
    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) stackOut.push(stackIn.pop());    // 从stackIn中取出数据，放入stackOut
        }

        if (stackOut.isEmpty()) throw new NoSuchElementException();
        return stackOut.pop();
    }
}
