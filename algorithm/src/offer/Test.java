package offer;

/**
 * Created by 熊佳新 on 2017/9/8.
 */
public class Test {
    private static int j = 0;

    private static boolean test1(int k) {
        j += k;
        return true;
    }

    public static void test2(int i) {
        boolean b;
        b = i < 100 | test1(3);
        b = i < 010 || test1(0);
    }

    public static void main(String[] args) {
        test2(0);
        System.out.println(j);
    }
}
