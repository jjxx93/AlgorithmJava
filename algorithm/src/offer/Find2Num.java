package offer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 将数组的每一个元素进行异或，得到的两个不同数字之间的异或，因为这两个数字不同，所以异或值必然不为0。
 * 找出异或值的第一个为1的数位，按照该数位对应值是否为0将数组分成两个子数组A和B，可以知道数组A包含两个不同数字的一个，其他都是两两相同的数字；
 * 数组B含包含两个不同数字的一个，其他也都是两两相同的数字，再分别进行异或，即可求得两个数。
 * Created by jjxx9 on 2017/4/29.
 */
public class Find2Num {
    static void find2Num(int[] arr) {
        int result = 0;
        int a = 0, b = 0, index = 0;
        for(int i = 0; i < arr.length; i++)
            result = result ^ arr[i];

        while(result != 0) {
            if((result & 0x1) == 0) {
                index++;
                result=result>>1;
            } else
                break;
        }
        int cmp = 1 << index;

        for(int i = 0; i < arr.length; ++i) {
            if((arr[i] & cmp) != 0) a = a ^ arr[i];
            else b = b ^ arr[i];
        }

        System.out.println(a + " " + b);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 3, 3};
        find2Num(nums);
    }
}
