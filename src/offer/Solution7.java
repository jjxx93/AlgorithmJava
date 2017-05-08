package offer;

import java.util.ArrayList;

public class Solution7 {
    public ArrayList<Integer> PrintFromTopToBottom(BinaryTreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) return arrayList;

        arrayList.add(0,root.val);

        if (root.left != null) {
            arrayList.add(root.left.val);
        }

        if (root.right != null) {
            arrayList.add(root.right.val);
        }

        if (root.left != null) {
            ArrayList<Integer> tempArray = PrintFromTopToBottom(root.left);
            arrayList.addAll(tempArray.subList(1, tempArray.size()));        // 去除root
        }

        if (root.right != null) {
            ArrayList<Integer> tempArray = PrintFromTopToBottom(root.right);
            arrayList.addAll(tempArray.subList(1, tempArray.size()));
        }


        return  arrayList;
    }

    public static void main(String[] args) {
        // 构建二叉树
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        //node3.right = node7;

        System.out.println(new Solution7().PrintFromTopToBottom(null));
    }
}
