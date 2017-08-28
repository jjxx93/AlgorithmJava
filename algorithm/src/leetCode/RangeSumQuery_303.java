package leetCode;

public class RangeSumQuery_303 {
	
	private int[] sums;

	public RangeSumQuery_303(int[] nums) {
		if (nums.length == 0) {
			this.sums = null;
		}else{
			this.sums = new int[nums.length];
			this.sums[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				this.sums[i] = this.sums[i-1] + nums[i];
			}
		}
	}


    public int sumRange(int i, int j) {
    	if (i == 0) {
			return sums[j];
		}else{
			return sums[j]-sums[i-1];
		}
    }
	
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4,5,6};
		RangeSumQuery_303 numArray = new RangeSumQuery_303(nums1);
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2, 5));
		System.out.println(numArray.sumRange(0, 5));
	}

}
