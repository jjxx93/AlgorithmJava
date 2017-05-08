package exam.Toutiao; /**
 * Created by jjxx9 on 2017/3/22.
 */
import java.util.Scanner;

public class Toutiao_1 {

    /**
     * 查找一个上升波

    public static int goUp(int[] ints, int tempStartIndex, int length) {
        for (int i = tempStartIndex; i < length - 1; ) {
            if (ints[i+1] > ints[i]) i++;
            else return i;
        }
        return length - 1;
    }

    /**
     * 查找一个下降波

    public static int goDown(int[] ints, int startIndex, int length) {
        for (int i = startIndex; i < length - 1; ) {
            if (ints[i+1] < ints[i]) i++;
            else return i;
        }
        return length - 1;
    }*/

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.valueOf(scanner.nextLine());
        String strIn = scanner.nextLine();
        String[] strings = strIn.split(" ");
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.valueOf(strings[i]);
        }

        int maxLength = 0, startIndex = 0, endIndex = 0;
        // 上升阶段
        for (int i = 0; i < n; ) {
            int tempStartIndex = i, tempEndIndex;
            //int midIndex = goUp(A, tempStartIndex, n);
            int midIndex = tempStartIndex;
            for (; midIndex < n - 1; ) {
                if (A[midIndex+1] > A[midIndex]) midIndex++;
                else break;
            }
            if (midIndex > tempStartIndex && midIndex < (n - 1)) {
                tempEndIndex = midIndex;
                for (; tempEndIndex < n - 1; ) {
                    if (A[tempEndIndex+1] < A[tempEndIndex]) tempEndIndex++;
                    else break;
                }
                if (tempEndIndex > midIndex && tempEndIndex <= (n - 1)) {
                    if ((tempEndIndex - tempStartIndex + 1) > maxLength) {
                        maxLength = tempEndIndex - tempStartIndex + 1;
                        startIndex = tempStartIndex;
                        endIndex = tempEndIndex;
                    }
                    i = endIndex;
                } else {
                    i = midIndex;
                }
            } else {
                i++;
            }
        }

        if (endIndex != 0) System.out.println(startIndex + " " + endIndex);
        else System.out.println("-1 -1");
    }
}

