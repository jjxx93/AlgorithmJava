package exam;

import java.util.Scanner;

/**
 * 一棵完全二叉排序树的深度为K，节点值为[1, 2^K-1]，给出K和任意三个节点的值，输出这三个节点的最小子树根。
 * 例：输入4 10 15 13，输出12
 * Created by jjxx9 on 2017/4/12.
 */
public class Tencent4Main {
    /**
     * 构建完全二叉树
     * @param k 树深
     * @return 二叉树数组
     */
    private static int[] constructFullBinaryTree(int k) {
        int[] binaryTree = new int[(int) Math.pow(2, k) - 1];

        binaryTree[0] = (binaryTree.length + 1) / 2;    // 第0层
        for (int i = 1; i < k; i++) {                   // 第1~k-1层
            int length = (int) Math.pow(2, i - 1);      // 第i - 1层的长度
            int startIndex = length - 1;                // 第i - 1层的起点
            int step = binaryTree[startIndex] / 2;      // 第i - 1层与第i层的步长
            for (int j = 0; j < length; j++) {
                binaryTree[(startIndex + j) * 2 + 1] = binaryTree[startIndex + j] - step;
                binaryTree[(startIndex + j) * 2 + 2] = binaryTree[startIndex + j] + step;
            }
        }

        return binaryTree;
    }

    /**
     * 根据完全二叉树和节点值，寻找从树根到节点的路径
     * @param k 树深
     * @param tree 完全二叉树
     * @param node 节点值
     * @return 从树根到节点的路径
     */
    private static int[] findPathFromRoot(int k, int[] tree, int node) {
        if (tree == null || node > tree.length || node < 1) return null;

        int[] path = new int[k];

        // 二分查找
        int index = 0;
        for (int i = 0; i < k; i++) {
            path[i] = index;
            if (node == tree[index]) break;
            if (node > tree[index]) index = 2 * index + 2;
            else index = 2 * index + 1;
        }

        return path;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        int[] binaryTree = constructFullBinaryTree(K);

        int[] path1 = findPathFromRoot(K, binaryTree, num1);
        int[] path2 = findPathFromRoot(K, binaryTree, num2);
        int[] path3 = findPathFromRoot(K, binaryTree, num3);

        int i = 0;              // 寻找三个数组的最初不相同位置
        for (; i < 4; i++) {
            if (path1[i] != path2[i] || path1[i] != path3[i]) {
                break;
            }
        }

        System.out.println(binaryTree[path1[i-1]]);
    }
}
