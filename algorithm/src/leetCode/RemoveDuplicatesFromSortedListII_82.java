/**
 * 
 */
package leetCode;


/**
 * @author jiax
 * ѵ������ʹ��
 */
public class RemoveDuplicatesFromSortedListII_82 {
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0); 
		dummy.next = head;
		
        for (ListNode pre = dummy; pre.next!=null; ) {
            ListNode q = pre.next;
            if (q.next==null || (q.next!=null && q.val!=q.next.val)) { pre = pre.next; }
            else {
                ListNode r = q.next.next;
                while (r!=null && r.val==q.val) { r = r.next; }
                pre.next = r;
            }
        } 
        
        return dummy.next;
        
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII_82 new1 = new RemoveDuplicatesFromSortedListII_82();
		
		int[] nums = {2,2,3,4,5};
		ListNode tail = new ListNode(Integer.valueOf(nums[4]));
		ListNode node3 = new ListNode(Integer.valueOf(nums[3]),tail);
		ListNode node2 = new ListNode(Integer.valueOf(nums[2]),node3);
		ListNode node1 = new ListNode(Integer.valueOf(nums[1]),node2);
		ListNode head = new ListNode(Integer.valueOf(nums[0]),node1);
		head = new1.deleteDuplicates(head);
		
		for (ListNode temp = head; temp != null;) {
			System.out.println(temp.val);
			temp = temp.next;                                                                                                                                                                                 
		}
	}

}
