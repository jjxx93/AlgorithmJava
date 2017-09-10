package offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * Created by jiax on 2017/1/5.
 */

public class _07_QueueWithTwoStacks {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty() && stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }

        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        _07_QueueWithTwoStacks solution4 = new _07_QueueWithTwoStacks();
        solution4.push(1);
        solution4.push(2);
        solution4.push(3);
        solution4.push(4);
        System.out.println(solution4.pop());
        System.out.println(solution4.pop());
        System.out.println(solution4.pop());
        System.out.println(solution4.pop());
    }
}
