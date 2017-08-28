package leetCode;

/**
 * Created by jiax on 2016/7/10.
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 */
public class SumOfTwoIntegers_371 {
    public int getSubstract(int a, int b) {
        while (b != 0) {
            int carrry = (~a) & b;
            a = a ^ b;
            b = carrry << 1;
        }

        return a;
    }

    public int getSum(int a, int b) {
        if(a == 0) return b;

        while (b != 0) {
            int carrry = a & b;
            a = a ^ b;
            b = carrry << 1;
        }

        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers_371 test = new SumOfTwoIntegers_371();

        System.out.println(test.getSubstract(1, 2));
    }
}
