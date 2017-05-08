package niuke;

/**
 * 对于一个矩阵，请设计一个算法，将元素按“之”字形打印。具体见样例。
 * 给定一个整数矩阵mat，以及他的维数n*m，请返回一个数组，其中元素依次为打印的数字。
 * 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9],[10,11,12]],4,3
 * 返回：[1,2,3,6,5,4,7,8,9,12,11,10]
 */
public class Printer {
    public int[] printMatrix(int[][] mat, int n, int m) {
       int[] temp = new int[n*m];

       int k = 0;
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
               if (i % 2 == 0) {
                   temp[k++] = mat[i][j];
               } else {
                   temp[k++] = mat[i][m - 1 - j];
               }
           }
        }

       return temp;
    }

    public int[] clockwisePrint(int[][] mat, int n, int m) {
        int[] temp = new int[n*m];

        int startX = 0, startY = 0, endX = n - 1, endY = m - 1;
        int i = 0, j = 0, k = 0;

        while(startX <= endX && startY <= endY) {
            if (startX == endX) {
                for (; j <= endY; j++) {
                    temp[k++] = mat[startX][j];
                }
                return temp;
            }

            if (startY == endY) {
                for (; i <= endX; i++) {
                    temp[k++] = mat[i][startY];
                }
                return temp;
            }

            // 从左上到右上
            for (; j < endY; j++) {
                temp[k++] = mat[i][j];
            }

            // 从右上到右下
            for (; i < endX; i++) {
                temp[k++] = mat[i][j];
            }

            // 从右下到左下
            for (; j > startY; j--) {
                temp[k++] = mat[i][j];
            }

            // 从左下到左上
            for (; i > startX; i--) {
                temp[k++] = mat[i][j];
            }

            startX++;
            startY++;
            endX--;
            endY--;
            i++;
            j++;
        }
        return temp;
    }
}
