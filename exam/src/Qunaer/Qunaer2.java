package Qunaer;

import java.util.Scanner;

/**
 * Created by 熊佳新 on 2017/9/9.
 */
public class Qunaer2 {
    private static int count = 0;
    static void findPath(int[] nums, int root, int target) {
        if(root >= nums.length || nums[root] == -1) return;
        target -= nums[root];
        if(target == 0) {
            count++;
        } else if (target < 0) {
            return;
        }

        findPath(nums, root * 2 + 1, target);
        findPath(nums, root * 2 + 2, target);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = Integer.valueOf(scanner.nextLine());
        String[] strings = scanner.nextLine().split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].charAt(0) != 'N') {
                nums[i] = Integer.valueOf(strings[i]);
            } else {
                nums[i] = -1;
            }
        }

        findPath(nums, 0, k);
        System.out.println(count);
    }
}

/*
12
1 5 11 3 2 N 5 3 2 N 1 10
 */