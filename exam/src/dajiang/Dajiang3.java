package dajiang;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * 统计每个j之前的d的个数和j之后的i的个数，然后乘机的和就是结果
 */
public class Dajiang3{

    /**
     *  辅助函数：取得对应字符串的组合数
     */
    private static int help(String str){
        if (str == null || "".equals(str)){
            return 0;
        }
        char[] array = str.toCharArray();
        int dCount = 0;
        int iCount = 0;
        int result = 0;
        // 保存j之前的d
        Map<Integer,Integer> dMap = new HashMap<Integer, Integer>();
        // 保存j之后的i
        Map<Integer,Integer> iMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'd'){
                dCount++ ;
            }
            if (array[i] == 'j'){
                dMap.put(i,dCount);
            }
        }

        for (int i = array.length-1; i >= 0; i--) {
            if (array[i] == 'i'){
                iCount++ ;
            }
            if (array[i] == 'j'){
                iMap.put(i,iCount);
            }
        }
        // 计算所有的组合数
        for (Map.Entry<Integer,Integer> entry : dMap.entrySet()){
            result +=  iMap.get(entry.getKey()) * entry.getValue();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for(int i=0; i < number; i++){
            System.out.println(help(scanner.next()));
        }
    }
}