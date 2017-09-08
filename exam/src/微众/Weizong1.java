package 微众;

import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/4/25.
 */
public class Weizong1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n ;//任务量
        int a ,b ,c ;

        n = scanner.nextInt();//各类员工数量（不能超过）
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        int count = 0;//方案数量
        int sum;

        //第一层5
        for (int i = 0; i<=a; i++) {
            //第二层8
            for (int j = 0; j<=b; j++) {
                //第三层10
                for(int k=0;k<=c;k++){
                    sum = i*5+j*8+k*10;
                    if (sum ==n) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
