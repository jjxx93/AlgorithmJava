package offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 检查栈的弹出序列与压入序列是否匹配，其中压入序列中的数字各不相同。
 * 例如压入序列1、2、3、4、5，与弹出序列4、5、3、2、1匹配，与序列4、3、5、1、2不匹配。
 * Created by jjxx9 on 2017/5/2.
 */
public class IsPopOrder {
    public static boolean isPopOrder(int[] pushArray, int[] popArray) {
        if (pushArray == null || popArray == null) return false;
        if (pushArray.length < popArray.length) return false;

        Deque<Integer> tempStack = new ArrayDeque<>();

        int i = 0, j = 0;
        for (; j < popArray.length;) {      // 沿着弹出序列找
            if (tempStack.isEmpty() || tempStack.peek() != popArray[j]) {   // 虚拟栈顶元素不是弹出序列当前值
                if (i < popArray.length) tempStack.push(pushArray[i++]);    // 插入序列中还有值，插入栈
                else return false;                                          // 否则返回错误
            } else {
                tempStack.pop();
                j++;
            }
        }

        return true;
    }
}
