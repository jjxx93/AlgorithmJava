package offer;

/**一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * Created by jiax on 2017/1/6.
 */
public class Solution6 {
    public int JumpFloor(int target) {
        int n0 = 1, n1 = 1;
        while (target-- > 0) {
            n1 += n0;
            n0 = n1 - n0;
        }
        return n0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution6().JumpFloor(2));
    }
}
