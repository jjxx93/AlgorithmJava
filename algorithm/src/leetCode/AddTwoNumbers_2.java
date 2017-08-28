package leetCode;

/**
 * Created by jiax on 2016/7/10.
 *
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tempNode = head;
        int sumVal = 0;

        while(l1 != null || l2 != null || sumVal > 9) {
            sumVal = ((l1 != null)?l1.val:0) + ((l2 != null)?l2.val:0) + sumVal / 10;

            tempNode = tempNode.next = new ListNode(sumVal % 10);

            l1 = (l1 != null)?l1.next:null;
            l2 = (l2 != null)?l2.next:null;
        }

        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers_2 test = new AddTwoNumbers_2();

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode l11 = new ListNode(4);
        ListNode l21 = new ListNode(6);
        ListNode l12 = new ListNode(3);
        ListNode l22 = new ListNode(4);

        l1.next = l11;
        l2.next = l21;
        l11.next = l12;
        l21.next = l22;

        ListNode result = test.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
