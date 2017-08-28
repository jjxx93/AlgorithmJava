package expression;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 算数表达式计算
 * Created by jjxx9 on 2017/3/18.
 */
public class Expression {
    private String infixExpression;
    private String suffixExpression;

    /**
     * 中缀表达式转换成后缀表达式字符串
     * @param infixExpression 中缀表达式
     * @return 后缀表达式
     */
    public static String Infix2Suffix(String infixExpression) {
        //ArrayDeque<Integer> numDeque = new ArrayDeque<>();
        char[] infixChars = infixExpression.toCharArray();  // 前缀字符串
        Deque<Character> opDeque = new ArrayDeque<>();      // 操作符栈
        StringBuilder suffixExpression = new StringBuilder();

        for (int i = 0; i < infixChars.length; i++) {
            // 取出操作数
            if (Character.isDigit(infixChars[i])) {
                int numStartIndex = i;
                while (i + 1 < infixChars.length && Character.isDigit(infixChars[i+1])) {
                    i++;
                }
                suffixExpression.append(infixExpression.substring(numStartIndex, i+1));
                suffixExpression.append(' ');
            } else if (infixChars[i] == ')') {  // 操作符是')'
                while (opDeque.peek() != '(') { // 取出'('前的所有操作符
                    suffixExpression.append(opDeque.pop());
                }
                opDeque.pop();
            } else {
                // '('直接插入操作符栈
                // 其他操作符要从栈中取出比他优先级小的所有操作符
                if (infixChars[i] != '(' && !opDeque.isEmpty() && Operator.cmpPriority(infixExpression.charAt(i), opDeque.peek()) <= 0) {
                    suffixExpression.append(opDeque.pop());
                }
                opDeque.push(infixChars[i]);
            }
        }

        while (!opDeque.isEmpty()) {
            suffixExpression.append(opDeque.pop());
        }

        return suffixExpression.toString();
    }

    /**
     * 前缀表达式计算
     * @param infixExpression 前缀表达式
     * @return 计算结果
     */
    public static int computeInfixExpression(String infixExpression) {
        char[] infixChars = infixExpression.toCharArray();  // 前缀字符串
        Deque<Integer> numDeque = new ArrayDeque<>();       // 操作数栈

        return 0;
    }

    /**
     * 后缀表达式计算
     * @param suffixExpression 后缀表达式
     * @return 计算结果
     */
    public static int computeSuffixExpression(String suffixExpression) {
        char[] suffixChars = suffixExpression.toCharArray();  // 后缀字符串

        int op1, op2, result = 0;
        char token;
        Deque<Integer> numDeque = new ArrayDeque<>();       // 操作数栈
        for (int i = 0; i < suffixChars.length; i++) {
            token = suffixChars[i];
            // 取出两个操作数
            if (Character.isDigit(token)) {
                int numStartIndex = i;
                while (suffixChars[i+1] != ' ') {
                    i++;
                }
                op1 = Integer.valueOf(suffixExpression.substring(numStartIndex, ++i));
                numDeque.push(op1);

                if (Character.isDigit(suffixChars[i+1])) {
                    numStartIndex = ++i;
                    while (suffixChars[i + 1] != ' ') {
                        i++;
                    }
                    op2 = Integer.valueOf(suffixExpression.substring(numStartIndex, ++i));
                    numDeque.push(op2);
                }
            } else {
                op2 = numDeque.pop();
                op1 = numDeque.pop();

                result = Operator.operate(op1, op2, token);
                numDeque.push(result);
            }
        }

        return result;
    }

    /**
     * 中缀表达式计算
     * @param infixExpression 中缀表达式
     * @return 计算结果
     */
    public static int computeInfix(String infixExpression) {
        char[] infixChars = infixExpression.toCharArray();
        Deque<Integer> numDeque = new ArrayDeque<>();
        Deque<Character> opDeque = new ArrayDeque<>();

        for (int i = 0;i < infixChars.length;i++) {
            // 取出操作数，插入到操作数栈中
            if (Character.isDigit(infixChars[i])) {
                int numStart = i;
                while (i + 1 < infixChars.length && Character.isDigit(infixChars[i + 1])) {
                    i++;
                }
                numDeque.push(Integer.valueOf(infixExpression.substring(numStart,i+1)));
            } else if (infixChars[i] == ')') {
                while (opDeque.peek() != '(') {
                    numDeque.push(Operator.operate(numDeque.pop(), numDeque.pop(), opDeque.pop()));
                }
                opDeque.pop();
            } else {
                if (!opDeque.isEmpty() && infixChars[i] != '('  && Operator.cmpPriority(infixChars[i], opDeque.peek()) <= 0) {
                    numDeque.push(Operator.operate(numDeque.pop(), numDeque.pop(), opDeque.pop()));
                }
                opDeque.push(infixChars[i]);
            }
        }

        while (!opDeque.isEmpty()) {
            numDeque.push(Operator.operate(numDeque.pop(), numDeque.pop(), opDeque.pop()));
        }

        return numDeque.peek();
    }
}
