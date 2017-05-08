package sort;

/**
 * 基数排序
 * 思想：假设数序列中小于元素a的个数为n，则直接把n放到辅助序列的第n+1个位置上。
 * 计数排序假设输入的元素都是0到k之间的整数。
 * Created by jiax on 2016/7/8.
 */
public class Count {
    public static int[] findInterval(int[] intArr) {
        int[] nums = {intArr[0], intArr[0]};

        for (int i = 1; i < intArr.length; i++) {
            if (intArr[i] > nums[0]) {
                nums[0] = intArr[i];
            } else if (intArr[i] < nums[1]) {
                nums[1] = intArr[i];
            }
        }
        return nums;
    }

    public static void countSort(int[] intArr) {
        int[] nums = findInterval(intArr);
        int maxNum = nums[0];
        int minNum = nums[1];
        int interval = maxNum - minNum;

        int[] bucket = new int[interval + 1];
        
        for(int in : intArr) bucket[in - minNum]++;
        
        for (int i = 0, j = 0; i <= interval; i++) {
            while (bucket[i] > 0) {
                intArr[j++] = i + minNum;
                bucket[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] intArr = Utility.getIntArr();

        countSort(intArr);

        Utility.showIntArr(intArr);
    }
}
