package collections;

import java.util.Scanner;
import java.util.Stack;

/**
 * 使用栈来检测括号序列的合法性
 */
public class BracketsCheck {
    public static boolean check (char[] characters) {
        Stack<Character> characterStack = new Stack<>();

        for (char character:characters) {
            switch (character) {
                case '{':
                case '[':
                case '(':
                    characterStack.push(character);
                    break;
                case ')':
                    if (characterStack.empty() || characterStack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (characterStack.empty() || characterStack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (characterStack.empty() || characterStack.pop() != '{') {
                        return false;
                    }
                    break;
                default : break;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        char[] chars = string.toCharArray();
        System.out.println(BracketsCheck.check(chars));
    }
}
