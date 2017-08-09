package Ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 对于一个由一位十进制整数构成的二叉树，如果深度不超过4，可以用一个三位十进制整数构成的数组表示，具体规则如下：
 * 1， 百位数表示树的层次L，1<=L<=4；十位数表示在该层次中的位置P，1<=P<=8；个位数表示数值V。
 * 2， 数组里，L一定是单增的，也就是说后一个数的L大于等于前一个数的L。
 * 3， 对于同一个L，P也是单增的，就是说在L不变的情况下，后一个数的P大于或等于前一个数的P。
 * 例如：
 * [113, 215, 221]对应的树是：
 *    3
 *  /   \
 * 5     1
 * 现在要求这个树所有到叶子节点的路径和，对于[113, 215, 221] 这棵树，有两个路径3-5和 3-1，路径和是(3+5) + (3 + 1) = 12
 * 输入:
 * 输入数据包含若干行，每行是一个三位的十进制整数，空行或者0代表输入结束
 * 输出:
 * 一个整数
 * 输入范例:
113
215
221
0
 * 输出范例:
 * 12
 *
 * Created by jjxx9 on 2017/4/21.
 */
public class AliTest {
    public static int add(int root, int[] nums) {
        int sum = 0;
        if (nums[root * 2 + 1] != 0) sum += nums[root] + nums[root * 2 + 1] + add(root * 2 + 1, nums);
        if (nums[root * 2 + 2] != 0) sum += nums[root] + nums[root * 2 + 2] + add(root * 2 + 2, nums);

        return sum;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int temp;
        int[] nums = new int[15];

        while (in.hasNextInt() && (temp = in.nextInt()) != 0) {
            int hunderedsPlace = temp / 100;
            int tensPlace = (temp - hunderedsPlace * 100) / 10;
            int onesPlace = temp - hunderedsPlace * 100 - tensPlace * 10;

            if (hunderedsPlace == 1) nums[0] = onesPlace;
            else {
                nums[(int) Math.pow(2, hunderedsPlace - 2) + tensPlace - 1] = onesPlace;
            }
        }

        for (int j = 0; j < 15; j++) {
            System.out.print(nums[j] + " ");
        }
        System.out.println(add(0, nums));
    }
}
