package leetCode;

public class RotateArray_189{
	public static void rotate(int[] nums, int k) {
       int n = nums.length;
       int[] nums1 = nums.clone();
       if (k>n) {
		k = k%n;
       }
       for (int i = 0; i < n; i++) {
    	   if(i<k){
    		   nums[i] = nums1[n-k+i];
    	   }else {
			nums[i] = nums1[i-k];
    	   } 
       }
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,6,7};
		int k = 5;
		rotate(nums,k);
		for (int i : nums) {
			System.out.print(i);
		}
	}

}
