package niuke;

/**
 * Created by jiax on 2016/12/4.
 */
public class PackageTest {
    @org.junit.Test
    public void printMatrix() throws Exception {
        Printer printer = new Printer();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};

        int[] reInt1 = printer.printMatrix(mat, 4, 3);
        for (int in:reInt1) {
            System.out.print(in+" ");
        }

        System.out.println();
        int[][] mat1 = {{60,26,6,1},{67,90,47,2}};
        int[] reInt2 = printer.clockwisePrint(mat1, 2, 4);
        for (int in:reInt2) {
            System.out.print(in+" ");
        }
    }
}