package exam.Ali;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jjxx9 on 2017/4/26.
 */
public class Ali0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();//待匹配
        String reg = scanner.nextLine();//匹配规则

        //将规则转化为正则表达式
        reg = reg.replace("?", ".");
        reg = reg.replace("*", ".*");

        //匹配
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(inputString);
        boolean result = matcher.matches();

        if (result) {
            System.out.println("1");
        }else {
            System.out.println("0");
        }
    }
}
/*
100-trade-done
1*trade*done

200-trade-done
200-?*-done
 */