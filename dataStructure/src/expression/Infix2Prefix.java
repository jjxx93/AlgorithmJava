package expression;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * Created by jiax on 2016/7/4.
 */
public class Infix2Prefix {
    public void Infix2Prefix() {
        Scanner sc = new Scanner(System.in);
        String InfixExpression = sc.nextLine();
        sc.close();

        LinkedList<Integer> numDeque = new LinkedList<>();
        LinkedList<Character> opDeque = new LinkedList<>();

        for (int i = 0;i < InfixExpression.length();i++) {
            if (Character.isDigit(InfixExpression.codePointAt(i))) {
                int numStart = i;
                while (i + 1 < InfixExpression.length() && Character.isDigit(InfixExpression.codePointAt(i + 1))) {
                    i++;
                }
                numDeque.push(Integer.valueOf(InfixExpression.substring(numStart,i+1)));
            } else {
                if (Operator.getPriority(InfixExpression.charAt(i)) < 0) {
                    System.out.println("Input Error!");
                    return;
                } else if (InfixExpression.charAt(i) == ')') {
                    while (opDeque.peek() != '(') {
                        numDeque.push(Operator.operate(numDeque.pop(), numDeque.pop(), opDeque.pop()));
                    }
                    opDeque.pop();
                } else {
                    if (!opDeque.isEmpty() && InfixExpression.charAt(i) != '(' && Operator.cmpPriority(InfixExpression.charAt(i), opDeque.peek()) <= 0) {
                        numDeque.push(Operator.operate(numDeque.pop(), numDeque.pop(), opDeque.pop()));
                    }
                    opDeque.push(InfixExpression.charAt(i));
                }
            }
        }

        while (!opDeque.isEmpty()) {
            numDeque.push(Operator.operate(numDeque.pop(), numDeque.pop(), opDeque.pop()));
        }

        System.out.println(numDeque.peek());
    }

}
