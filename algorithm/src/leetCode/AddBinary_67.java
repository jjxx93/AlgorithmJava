package leetCode;

import java.util.LinkedList;

/**
 * Created by jiax on 2016/7/10.
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary_67 {
    public String addBinary(String a, String b) {
        LinkedList<Integer> listA = new LinkedList<>();
        LinkedList<Integer> listB = new LinkedList<>();
        LinkedList<Integer> resultArr = new LinkedList<>();

        for (int i = 0; i < a.length(); i++) {
            listA.push(Integer.valueOf(a.substring(i,i+1)));
        }

        for (int i = 0; i < b.length(); i++) {
            listB.push(Integer.valueOf(b.substring(i,i+1)));
        }
        
        int carry = 0;
        
        while (!listA.isEmpty() || !listB.isEmpty() || carry != 0) {
            int sum = (listA.isEmpty() ? 0 : listA.pop()) + (listB.isEmpty() ? 0 : listB.pop()) + carry;
            
            carry = sum / 2;
            resultArr.push(sum % 2); 
        }
        
        String resultStr = "";
        while (!resultArr.isEmpty()){
            resultStr += resultArr.pollFirst();
        }

        return resultStr;
    }

    public static void main(String[] args) {
        AddBinary_67 test = new AddBinary_67();

        System.out.println(test.addBinary("11", "1"));
    }
}
