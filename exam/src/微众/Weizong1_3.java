package 微众;

import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/9/28.
 */
public class Weizong1_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), count=2;

        while(n>1){
            if(n%2==0){
                n--;
            }
            else{
                if(Judgement(n)){
                    count++;
                    n--;
                }
                else {
                    n--;
                }

            }
        }
        System.out.println(count);
    }


    static boolean Judgement(long m) {
        if(m<0) return false;
        String temp="";
        temp=Long.toBinaryString(m);
        for(int i=0;i<temp.length()/2;i++){
            if(temp.charAt(i)!=temp.charAt(temp.length()-i-1))
                return false;
        }
        return true;
    }
}
