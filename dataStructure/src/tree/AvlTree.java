package tree;

/**
 * Created by jjxx9 on 2017/3/16.
 */
public class AvlTree<T extends Comparable> {
    private static class AvlNode<T> {
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;

        AvlNode(T theElement) {
            this(theElement, null, null);
        }

        AvlNode(T theElement, AvlNode<T> o, AvlNode<T> o1) {
            this.element = theElement;
            this.left = o;
            this.right = o1;
            this.height = 0;
        }
    }

    private AvlNode<T> root;

    /**
     * 求节点t的高度
     * @param t 节点
     * @return 高度
     */
    private int height(AvlNode<T> t) {
        return t == null ? -1 : t.height;
    }

    /**
     * 在子树中插入值
     * @param x 待插入值
     * @return 新子树根
     */
    public void insert(T x) {
        root = insert(x, root);
    }

    /**
     * 在子树中插入值
     * @param x 待插入值
     * @param t 子树根
     * @return 新子树根
     */
    public AvlNode<T> insert(T x, AvlNode<T> t) {
        if (t == null) return new AvlNode<T>(x);

        // 树非空，找到插入位置
        int compareResult;
        AvlNode<T> index = root;     // 寻找插入位置索引

        // 寻找到插入位置就插入
        while ( (compareResult = x.compareTo(index.element)) != 0 ) {   // 当前索引位置值不等于插入值
            if (compareResult < 0 ) {
                if (index.left == null) {       // 寻找到插入位置
                    index.left = new AvlNode<>(x);
                    break;
                }
                else index = index.left;        // 未寻找到插入位置，继续寻找
            } else if (index.right == null){    // 寻找到插入位置
                index.right = new AvlNode<>(x);
                break;
            } else {                            // 未寻找到插入位置，继续寻找
                index = index.right;
            }
        }

        return balance(t);
    }

    /**
     * 从树上删除元素x
     * @param x 待删除元素
     */
    public void remove(T x) {
        root = remove(x, root);
    }

    /**
     * 从子树t上删除元素x
     * @param x 待删除元素
     * @param t 子树
     * @return 新子树
     */
    public AvlNode<T> remove(T x, AvlNode<T> t) {
        if (t == null) return t;

        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.right != null && t.left != null) { // 找到此节点，有2个子节点
            t.element = findMin(t.right).element;       // 找到右子树上的最小节点，与当前节点对调
            t.right = remove(t.element, t.right);       // 在右子树上删除最小节点
        } else {
            t = (t.left != null) ? t.left : t.right;    // 找到此节点，子节点数少于2,
        }

        return balance(t);
    }

    /**
     * 按照顺序打印树
     */
    public void printTree() {
        if (isEmpty()) System.out.println("Empty Tree!");
        else printTree(root);
    }

    /**
     * 按照顺序打印树
     * @param temp 树根
     */
    public void printTree(AvlNode<T> temp) {
        if (temp != null) {
            printTree(temp.left);
            System.out.println(temp.element);
            printTree(temp.right);
        }
    }

    /**
     * 检查二叉树是否为空
     * @return boolean
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 寻找此二叉树中的最小值
     * @return T
     */
    public T findMin() {
        if (isEmpty()) return null;
        return findMin(root).element;
    }

    /**
     * 寻找子二叉树中的最小值
     * @param root 子二叉树根
     * @return BinaryNode<T>
     */
    public AvlNode<T> findMin(AvlNode<T> root) {
        if (root == null) return null;

        while ( root.left != null ) {
            root = root.left;
        }

        return root;
    }

    /**
     * 保证t的两边是平衡的
     * @param t 树t
     * @return
     */
    private AvlNode<T> balance(AvlNode<T> t) {
        if (t == null) return t;

        if (height(t.left) - height(t.right) > 1) {
            if (height(t.left.left) >= height(t.left.right)) t = rotateWithLeftChild(t);
            else t = doubleRotateWithLeftChild(t);
        } else if (height(t.right) - height(t.left) > 1) {
            if (height(t.right.right) >= height(t.right.left)) t = rotateWithRightChild(t);
            else t = doubleRotateWithRightChild(t);
        }

        t.height = Math.max(height(t.left), height(t.right));
        return t;
    }

    /**
     * 左旋转
     * @param k1 旋转前的子树根
     * @return 旋转后的子树根
     */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {
        AvlNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(k1.height, height(k1.right)) + 1;
        return k2;
    }

    /**
     * 右旋转
     * @param k2 旋转前的子树根
     * @return 旋转后的子树根
     */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /**
     * 双左旋转
     * @param k1 旋转前的子树根
     * @return 旋转后的子树根
     */
    private AvlNode<T> doubleRotateWithRightChild(AvlNode<T> k1) {
        AvlNode<T> k3 = k1.right;
        AvlNode<T> k2 = k3.left;
        k1.right = k2.left;
        k3.left  = k2.right;
        k2.left  = k1;
        k2.right = k3;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k3.height = Math.max(height(k3.left), height(k3.right)) + 1;
        k2.height = Math.max(k1.height, k3.height) + 1;

        return k2;
    }

    /**
     * 双右旋转
     * @param k3 旋转前的子树根
     * @return 旋转后的子树根
     */
    private AvlNode<T> doubleRotateWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
}