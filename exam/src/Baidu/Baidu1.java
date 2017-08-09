package Baidu;

import java.util.*;

/**
 * Created by jjxx9 on 2017/4/27.
 */
public class Baidu1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCount = scanner.nextInt();
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        while (count < numCount) {
            int num = scanner.nextInt();
            set.add(num);
            count++;
        }

        final List<Integer> list = new ArrayList<>();
        list.addAll(set);

        Collections.sort(list);

        if (list.size() >= 3) {
            System.out.println(list.get(2));
        }else {
            System.out.println("-1");
        }

    }
}
