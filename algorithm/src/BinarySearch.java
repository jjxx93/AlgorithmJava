/**
 * 二分查找
 */

public class BinarySearch {
    public static int binarySearch (int[] intNums, int aimNum) {
        int start = 0, end = intNums.length - 1;

        while (start <= end) {
            int middle = (start - end) / 2 + end;   // (start + end) / 2 可能溢出
            if (intNums[middle] == aimNum) {
                return middle;
            }

            if (intNums[middle] < aimNum) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return -1;      // 没有找到值
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.binarySearch(new int[]{1, 2, 3, 4, 5}, 2));
    }
}
