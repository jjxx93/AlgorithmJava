package exam.Toutiao;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by jjxx9 on 2017/4/18.
 */
public class Toutiao2_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<Long> integers = new HashSet<>();
        long intIn;
        while ((intIn = scanner.nextLong()) != 0) {
            integers.add(intIn);
        }

        System.out.println(integers.size());
    }
}

/*
12933
1110001110
59220
69433
59220
1110001110
10000000
0
 */