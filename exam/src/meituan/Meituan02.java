package meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/8/31.
 */
public class Meituan02 {
    public static String check(int[] arr,int N) {
        if(N <= 1) {
            return "No";
        }
        Arrays.sort(arr);

        int sum = 0;
        for(int i = 0; i < N-1; i++) {
            sum += arr[i];
        }

        if(sum >= arr[N-1]) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(check(arr, n));
    }
}
/*
2
10 20
Input Sample 2
4
2 3 3 1
 */