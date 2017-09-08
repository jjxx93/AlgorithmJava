package 京东;

import java.util.Scanner;

/**
 * Created by 熊佳新 on 2017/9/8.
 */
public class Jingdong1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int result = process(scanner.next());
            System.out.println(result);
        }
        scanner.close();
    }

    private static int process(String string){
        int res = 1, tmp = 0;
        for(int i=0; i<string.length(); i++){
            if (string.charAt(i)=='(') {
                tmp++;
            } else {
                res *= tmp;
                tmp--;
            }
        }
        return res;
    }
}
