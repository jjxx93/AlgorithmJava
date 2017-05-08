package exam.Baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by jjxx9 on 2017/4/27.
 */
public class Baidu2 {
    public static double count_triangle_area(int[] a,int[] b,int[] c){
        double area = -1;

        double side[] = new double[3];//存储三条边的长度;

        side[0] = sqrt(pow(a[0]- b[0], 2)+pow(a[1] - b[1], 2) + pow(a[2] - b[2], 2));
        side[1] = sqrt(pow(a[0]- c[0], 2)+pow(a[1] - c[1], 2) + pow(a[2] - c[2], 2));
        side[2] = sqrt(pow(c[0]- b[0], 2)+pow(c[1] - b[1], 2) + pow(c[2] - b[2], 2));

        //不能构成三角形;
        if(side[0]+side[1]<=side[2] || side[0]+side[2]<=side[1] || side[1]+side[2]<=side[0]) return area;

        //利用海伦公式。s=sqr(p*(p-a)(p-b)(p-c));
        double p = (side[0]+side[1]+side[2])/2; //半周长;
        area = sqrt(p*(p-side[0])*(p-side[1])*(p-side[2]));

        return area;
    }

    // 计算全相同颜色
    public static double getMaxSize(List<int[]> points) {
        double maxSize = 0;

        if (points.size() >= 3) {
            int size = points.size();
            for (int i = 0; i < size - 2; i++) {
                for (int j = i + 1; j < size - 1; j++) {
                    for (int k = 0; k < size; k++) {
                        double tempSize = count_triangle_area(points.get(i), points.get(j), points.get(k));
                        if (tempSize > maxSize) maxSize = tempSize;
                    }
                }
            }
        }

        return maxSize;
    }

    // 计算全不同颜色
    public static double getMaxSize(List<int[]> points1, List<int[]> points2, List<int[]> points3) {
        double maxSize = 0;
        int size1 = points1.size(), size2 = points2.size(), size3 = points3.size();

        if (size1 == 0 || size2 == 0 || size3 == 0) return maxSize;

        for (int[] aPoints1 : points1) {
            for (int[] aPoints2 : points2) {
                for (int[] aPoints3 : points3) {
                    double tempSize = count_triangle_area(aPoints1, aPoints2, aPoints3);
                    if (tempSize > maxSize) maxSize = tempSize;
                }
            }
        }

        return maxSize;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        List<int[]> redPoints = new ArrayList<>();
        List<int[]> greenPoints = new ArrayList<>();
        List<int[]> blackPoints = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String stringIn = scanner.next();

            int[] point = new int[3];

            point[0] = scanner.nextInt();
            point[1] = scanner.nextInt();
            point[2] = scanner.nextInt();

            if (stringIn.startsWith("R")) redPoints.add(point);
            else if (stringIn.startsWith("G")) greenPoints.add(point);
            else blackPoints.add(point);
        }

        double maxSize = 0;
        // 计算全相同
        double tempSize = getMaxSize(redPoints);
        if (tempSize > maxSize) maxSize = tempSize;
        tempSize = getMaxSize(greenPoints);
        if (tempSize > maxSize) maxSize = tempSize;
        tempSize = getMaxSize(blackPoints);
        if (tempSize > maxSize) maxSize = tempSize;

        // 计算全不同颜色
        tempSize = getMaxSize(redPoints, greenPoints, blackPoints);
        if (tempSize > maxSize) maxSize = tempSize;

        System.out.printf("%.5f",maxSize);
    }
}

/*
5
R 0 0 0
R 0 4 0
R 0 0 3
G 92 14 7
G 12 16 8
 */