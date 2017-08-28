package leetCode;

import java.util.HashSet;
import java.util.Scanner;

public class ContainsDuplicate_217 {
	public boolean containsDuplicate(int[] nums) {
		int length = nums.length;
		
		if(length <= 1) return false;
		
	    HashSet<Integer> set = new HashSet<Integer>();
	    
	    for(int i = 0; i < length; i++){
	        if(!set.add(nums[i])) return true;
	    }
	    return false;
    }
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ContainsDuplicate_217 new1 = new ContainsDuplicate_217();
		int[] nums = new int[5];
		for (int i = 0; i < 5; i++) {
			nums[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println(new1.containsDuplicate(nums));
	}

}
