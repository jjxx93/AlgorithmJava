package offer;

/**
 * 输入一个整数数组，调整数组中数字的顺序，将所有奇数排到偶数前面。
 * 输入：{1, 2, 4, 3, 5}
 * 输出：{1, 3, 5, 2, 4}
 * Created by 熊佳新 on 2017/9/10.
 */
public class _14_ReorderOddEven {
   static void reorderOddEven(int[] nums) {
       if (nums == null || nums.length == 0) {
           return;
       }

       int startIndex = 0, endIndex = nums.length - 1;
       while (startIndex < endIndex) {
           // 向后移动startIndex直到找到一个偶数
           while (startIndex < endIndex && (nums[startIndex] & 0x1) != 0) {
               startIndex++;
           }

           // 向前移动endIndex直到找到一个奇数
           while (startIndex < endIndex && (nums[endIndex] & 0x1) == 0) {
               endIndex--;
           }

           if (startIndex < endIndex) {
               int temp = nums[startIndex];
               nums[startIndex] = nums[endIndex];
               nums[endIndex] = temp;
           }
       }
   }
}
