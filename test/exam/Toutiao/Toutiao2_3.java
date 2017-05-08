package exam.Toutiao;

import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/4/18.
 */
public class Toutiao2_3 {
    /**
     * 查找数组第i行第j列的位置
     * @param i 行
     * @param j 列
     * @return 位置
     */
    public static int getIndex(int i, int j) {
        return i * (i + 1) / 2 + j;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int length = getIndex(n - 1, n - 1);
        int[] nums = new int[length];
        for (int i = 0; i != length; i++) {
            nums[i] = scanner.nextInt();
            System.out.println(nums[i]);
        }
    }
}
/*
3 4
1
2 3
1 1 1
 */