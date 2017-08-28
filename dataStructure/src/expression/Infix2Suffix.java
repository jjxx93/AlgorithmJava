package expression;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jiax on 2016/7/4.
 */
public class Infix2Suffix {
    public void Infix2Suffix() {
        Scanner sc = new Scanner(System.in);
        String InfixExpression = sc.nextLine();
        sc.close();

        //ArrayDeque<Integer> numDeque = new ArrayDeque<>();
        LinkedList<Character> opDeque = new LinkedList<>();
        String suffixExpression = "";

        for (int i = 0; i < InfixExpression.length(); i++) {
            if (Character.isDigit(InfixExpression.codePointAt(i))) {
                int numStart = i;
                while (i + 1 < InfixExpression.length() && Character.isDigit(InfixExpression.codePointAt(i + 1))) {
                    i++;
                }
                //numDeque.push(Integer.valueOf(InfixExpression.substring(numStart,i+1)));
                suffixExpression += InfixExpression.substring(numStart, i + 1);
            } else {
                if (Operator.getPriority(InfixExpression.charAt(i)) < 0) {
                    System.out.println("Input Error!");
                    return;
                } else if (InfixExpression.charAt(i) == ')') {
                    while (opDeque.peek() != '(') {
                        suffixExpression += opDeque.pop();
                    }
                    opDeque.pop();
                } else {
                    if (!opDeque.isEmpty() && InfixExpression.charAt(i) != '(' && Operator.cmpPriority(InfixExpression.charAt(i), opDeque.peek()) <= 0) {
                        suffixExpression += opDeque.pop();
                    }
                    opDeque.push(InfixExpression.charAt(i));
                }
            }
        }

        while (!opDeque.isEmpty()) {
            suffixExpression += opDeque.pop();
        }

        System.out.println(suffixExpression);
    }

}
