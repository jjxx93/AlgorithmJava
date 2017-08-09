package Ali;

import java.util.*;

public class Ali2 {
    public static int resolve(String expr) {
        char[] suffixChars = expr.toCharArray();  // 后缀字符串

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
                op1 = Integer.valueOf(expr.substring(numStartIndex, ++i));
                if (numDeque.size() >= 16) return -2; // 向上溢出
                numDeque.push(op1);

//                if (Character.isDigit(suffixChars[i+1])) {
//                    numStartIndex = ++i;
//                    while (suffixChars[i + 1] != ' ') {
//                        i++;
//                    }
//                    op2 = Integer.valueOf(expr.substring(numStartIndex, ++i));
//                    numDeque.push(op2);
//                }
            } else if (token != ' ') {
                if (token != '^') {
                    if (numDeque.isEmpty()) return -1;  // 向下溢出
                    op2 = numDeque.pop();

                    if (numDeque.isEmpty()) return -1;  // 向下溢出
                    op1 = numDeque.pop();

                    result = operate(op1, op2, token);
                    numDeque.push(result);
                } else {
                    if (numDeque.isEmpty()) {   // 向下溢出
                        return -1;
                    } else {                    // 自增
                        op1 = numDeque.pop();
                        numDeque.push(++op1);
                    }
                }

            }
        }

        return result;
    }

    public static int operate(int operator2, int operator1, char operator){
        switch (operator) {
            case '+':
                return operator1 + operator2;
            case '*':
                return operator1 * operator2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }


}

/*
1 1 + 2 ^ *
 */