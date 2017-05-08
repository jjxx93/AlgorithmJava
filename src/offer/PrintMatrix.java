package offer;

/**
 * 顺时针打印矩阵
 * Created by jjxx9 on 2017/4/14.
 */
public class PrintMatrix {
    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix[0] == null) return;

        int column = matrix[0].length;
        int row = matrix.length;
        int start = 0;
        int endX = column - 1 - start, endY = row - 1 - start;
        while (endX >= start || endY >= start) {
            for (int i = start; i <= endX; i++) {
                System.out.print(matrix[start][i] + " ");
            }
            System.out.println();

            if (endX >= 0) {
                for (int i = start + 1; i <= endY; i++) {
                    System.out.print(matrix[i][endX] + " ");
                }
                System.out.println();
            }

            if (start < endX) {
                for (int i = endX - 1; i >= start; i--) {
                    System.out.print(matrix[endY][i] + " ");
                }
                System.out.println();

                for (int i = endY - 1; i > start; i--) {
                    System.out.print(matrix[i][start] + " ");
                }
                System.out.println();
            }

            start++;
            endX = column - 1 - start;
            endY = row - 1 - start;
        }
    }
}
