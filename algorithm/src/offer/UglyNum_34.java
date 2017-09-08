package offer;

/**
 * 丑数：只包含因子2、3、5的数，第一个丑数为1。
 * 求第N个丑数
 */
public class UglyNum_34 {
    static int findUglyNum(int n) {
        if(n <= 0) {
            return 0;
        }

        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int nextUglyNumIndex = 1;
        int index2 = 0, index3 = 0, index5 = 0;

        while (nextUglyNumIndex < n) {
            int min = Math.min(uglyNums[index2] * 2, uglyNums[index3] * 3);
            min = Math.min(min, uglyNums[index5] * 5);
            uglyNums[nextUglyNumIndex] = min;

            while (index2 < (n - 1) && uglyNums[index2] * 2 <= uglyNums[nextUglyNumIndex]) {
                index2++;
            }
            while (index3 < (n - 1) && uglyNums[index3] * 3 <= uglyNums[nextUglyNumIndex]) {
                index3++;
            }
            while (index5 < (n - 1) && uglyNums[index5] * 5 <= uglyNums[nextUglyNumIndex]) {
                index5++;
            }

            nextUglyNumIndex++;
        }

        return uglyNums[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(UglyNum_34.findUglyNum(4));
    }
}
