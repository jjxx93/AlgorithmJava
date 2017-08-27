package Didi;

import java.util.*;

public class Didi01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayString = scanner.nextLine().split(" ");

        //list排序
        List<Integer> nums = new ArrayList<>();
        for (String num : arrayString) {
            nums.add(Integer.valueOf(num));
        }

        int k = scanner.nextInt();

        Collections.sort(nums, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        System.out.println(nums.get(k-1));
    }
}

/*
45 67 33 21
2
 */