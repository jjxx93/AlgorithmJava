package 远景;

import java.util.Arrays;

/**
 * search in rotated sorted array ii
 *
 * Created by jjxx9 on 2017/9/6.
 */
public class yuanjing2 {
    public boolean search(int[] A, int target) {
        Arrays.sort(A);     // 排序

        int start = 0;      // 二分查找
        int end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(A[mid] == target) {
                return true;
            } else if(A[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
