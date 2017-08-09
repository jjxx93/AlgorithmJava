package Huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/4/2.
 */
public class Huawei_1 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Map<Integer, Integer> intMap = new HashMap<>();
            while(in.hasNext()) {
                String stringIn = in.next();
                String[] arrString = stringIn.split(",");
                int arrLen = arrString.length;
                int[] intArr = new int[arrLen];
                for(int i=0;i<arrLen;i++){
                    intArr[i]=Integer.parseInt(arrString[i]);
                }
                //统计各种数字的个数
                for(int i=0;i<arrLen;i++){
                    if(intMap.containsKey(intArr[i])){
                        intMap.put(intArr[i], intMap.get(intArr[i])+1);
                    }else{
                        intMap.put(intArr[i], 1);
                    }
                }
                for(Integer key:intMap.keySet()){
                    System.out.println(key+"("+intMap.get(key)+")");
                }
                break;
            }


    }
}
