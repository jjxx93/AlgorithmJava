package offer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jjxx9 on 2017/5/2.
 */
public class PrintTreeByLayerTest {
    @Test
    public void printTreeByLayer() throws Exception {
        System.out.println(PrintTreeByLayer.printTreeByLayer(null));

        BinaryTreeNode root = new BinaryTreeNode(0);
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;
        System.out.println(PrintTreeByLayer.printTreeByLayer(root));
    }

}