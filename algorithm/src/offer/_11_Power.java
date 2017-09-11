package offer;

/**
 * 数值的整数次方
 *
 * Created by 熊佳新 on 2017/9/10.
 */
public class _11_Power {
    static double getPower(double base, int exponent) {
        if (base == 0 && exponent < 0) {
            return 0;
        }

        int absExponent = exponent;
        if (exponent < 0) {
            absExponent = -exponent;
        }

        double result = powerWithAbsExponent(base, absExponent);

        if (exponent < 0) {
            result = 1 / result;
        }

        return result;
    }

    private static double powerWithAbsExponent(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return base;
        }

        double result = powerWithAbsExponent(base, exponent >> 2);
        result *= result;
        if ((exponent & 0x01) == 1) {   // 奇数
            result *= base;
        }
        return result;
    }
}
