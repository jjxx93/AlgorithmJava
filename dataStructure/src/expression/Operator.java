package expression;

/**
 * Created by jiax on 2016/7/4.
 */
public class Operator {
    public static int getPriority(char operator){
        switch (operator) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case ')':
                return 3;
            default:
                return -1;
        }
    }

    public static int cmpPriority(char operator1, char operator2){
        return getPriority(operator1) - getPriority(operator2);
    }

    public static int operate(int operator2, int operator1, char operator){
        switch (operator) {
            case '+':
                return operator1 + operator2;
            case '-':
                return operator1 - operator2;
            case '*':
                return operator1 * operator2;
            case '/':
                return operator1 / operator2;
            default:
                return 0;
        }
    }
}
