package Huawei;

import java.util.LinkedList;

/**
 * Created by xiongjiaxin on 2017/7/12.
 */
public class Huawei2_2 {
    private static boolean hasBigger(int first , LinkedList<Integer> intsIn) {
        for (int in : intsIn) {
            if (in > first) {
                return true;
            }
        }

        return false;
    }

    private static int[] printOrder(int[] ints) {
        if (ints.length == 0) {
            return ints;
        }

        LinkedList<Integer> intsIn = new LinkedList<>();
        for (int in : ints) {
            intsIn.add(in);
        }

        int i = 0;
        while(intsIn.size() > 0) {
            int first = intsIn.getFirst();
            intsIn.remove(0);
            if (intsIn.size() > 0 && hasBigger(first, intsIn)) {
                intsIn.add(first);
            } else {
                ints[i++] = first;
            }
        }

        return ints;
    }

    public static void main(String[] args) {
        int[] ints = {9, 3, 5};
        ints = printOrder(ints);
        for (int in : ints) {
            System.out.print(in + ", ");
        }
    }
}
