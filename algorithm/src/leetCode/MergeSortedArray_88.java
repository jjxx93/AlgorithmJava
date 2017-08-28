/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 */
package leetCode;

/**
 * @author jiax
 *�Ӻ���ǰ�Ƚ�nums1��nums2�����ֵĴ�С���ٽ��������뵽nums1��
 */
public class MergeSortedArray_88 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int newIndex = m + n - 1, nums1Index = m - 1, nums2Index = n - 1;
        
        while (nums1Index >= 0 && nums2Index >= 0) {
			if (nums1[nums1Index] > nums2[nums2Index]) {
				nums1[newIndex] = nums1[nums1Index];
				newIndex --;
				nums1Index --;
			}else {
				nums1[newIndex] = nums2[nums2Index];
				newIndex --;
				nums2Index --;
			}
		}
        
        while (nums1Index >= 0) {
			nums1[newIndex] = nums1[nums1Index];
			newIndex --;
			nums1Index --;
		}
        
        while (nums2Index >= 0) {
			nums1[newIndex] = nums2[nums2Index];
			newIndex --;
			nums2Index --;
		}
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSortedArray_88 new1 = new MergeSortedArray_88();
		int[] nums1 = {1,2,4,5,6,0};
		int m = 5;
		int[] nums2 = {3};
		int n = 1;
		new1.merge(nums1, m, nums2, n);
		for (int i : nums1) {
			System.out.println(i);
		}
	}

}
