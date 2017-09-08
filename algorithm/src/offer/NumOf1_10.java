package offer;

/**
 * 从1到n的整数中1出现的次数
 * Created by jjxx9 on 2017/5/5.
 */
public class NumOf1_10 {
    public static int getCountOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumOf1_10.getCountOf1(-10));
    }
}
