package dajiang;

import java.util.Scanner;

public class Dajiang1 {
    /**
     * 求两个数的二进制中不同的位数
     * @param m
     * @param n
     * @return 返回不同的位数的个数
     */
    public static int countBitDiff(long m, long n) {
        //异或
        long ans = m ^ n;
        //求ans中1的个数
        int count = 0;
        while(ans != 0){
            ans &= (ans -1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        long[] nums = new long[length];
        for (int i = 0; i < length; i++) {
            nums[i] = sc.nextLong();
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                sum += countBitDiff(nums[i], nums[j]);
            }
        }

        System.out.println(sum);
    }
}
