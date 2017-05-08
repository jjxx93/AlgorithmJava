package tree;

import org.junit.Test;
import tree.AvlTree;

/**
 * Created by jjxx9 on 2017/3/16.
 */
public class AvlTreeTest {
    AvlTree<Integer> avlTree = new AvlTree<>();

    {
        avlTree.insert(4);
        avlTree.insert(2);
        avlTree.insert(1);
        avlTree.insert(3);
        avlTree.insert(5);
        avlTree.insert(6);
    }

    @Test
    public void insert() throws Exception {
        avlTree.printTree();
    }

    @Test
    public void remove() throws Exception {
        avlTree.printTree();
        System.out.println();
        avlTree.remove(1);
        avlTree.printTree();
    }

}