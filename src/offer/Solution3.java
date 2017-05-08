package offer;

import java.util.ArrayList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * Created by jiax on 2017/1/5.
 */
public class Solution3 {
     public class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }
     }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        if (listNode != null) {
            arrayList = this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }

        return arrayList;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        ListNode node0 = solution3.new ListNode(0);
        ListNode node1 = solution3.new ListNode(1);
        ListNode node2 = solution3.new ListNode(2);

        node0.next = node1;
        node1.next = node2;

        System.out.println(solution3.printListFromTailToHead(node0));
    }
}
