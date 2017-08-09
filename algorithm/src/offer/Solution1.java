package offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * Created by jiax on 2017/1/4.
 */
public class Solution1 {

    // 二分法查找
    public boolean Find(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            int left  = 0;
            int right = array[i].length - 1;

            while (left <= right) {
                int arrayMid = (left + right) / 2;

                if (target == array[i][arrayMid]) { return true; }
                else if (target < array[i][arrayMid]) { right = arrayMid - 1; }
                else { left = arrayMid + 1; }
            }
        }

        return false;
    }

    /**
     * 当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,
     即col--；
     当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,
     即row++；
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int [][] array) {
        int row = 0;
        int col = array[0].length - 1;
        while(row <= array.length-1 && col >= 0){
            if(target == array[row][col])
                return true;
            else if(target > array[row][col])
                row++;
            else
                col--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        //int[][] array = new int[][]{};

        System.out.println(new Solution1().find(15, array));
    }
}
