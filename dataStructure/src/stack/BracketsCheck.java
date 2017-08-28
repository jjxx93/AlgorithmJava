package stack;

import java.util.Stack;

/**
 * 使用栈来检测括号序列的合法性
 * Created by jiax on 2016/11/23.
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
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(args[0]);
        char[] chars = args[0].toCharArray();
        System.out.println(BracketsCheck.check(chars));
    }
}
