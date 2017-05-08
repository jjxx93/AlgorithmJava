package offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 定义一个能够得到最小元素的栈，
 * 其中min、push、pop的时间复杂度都是O(1)。
 * Created by jjxx9 on 2017/5/2.
 */
public class MinStack {
    private Deque<Integer> dataStack;   // 数据栈
    private Deque<Integer> minStack;    // 最小数栈

    public MinStack() {
        dataStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    /**
     * 插入栈
     * 如果数据栈为空，插入数据到最小数栈
     * 如果数据栈不为空，但栈顶元素大于插入元素，插入数据到最小数栈
     * @param num 插入元素
     */
    public void push(int num) {
        if (dataStack.isEmpty() || dataStack.peek() > num) {
            minStack.push(num);
        }
        dataStack.push(num);
    }

    /**
     * 弹出元素
     * 如果最小数栈顶元素是最小值，则也弹出
     * @return 栈顶元素
     */
    public int pop() {
        int result = dataStack.pop();
        if (minStack.peek() == result) minStack.pop();
        return result;
    }

    /**
     * 返回栈中最小值
     * @return 栈中最小值
     */
    public int min() {
        return minStack.peek();
    }
}
