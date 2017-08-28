package leetCode;

import java.util.HashMap;

public class ContainsDuplicateII_219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
        	int j = i + 1;
			while(j < nums.length - 1 && j <= i + k) {
				if (nums[i] == nums[j]) {
					return true;
				}else {
					j++;
				}
			}
		}  
        return true;
    }

	public boolean containsNearbyDuplicate1(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int i = 0; i < nums.length; ++i){
	        if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
	        map.put(nums[i], i);
	    }
	    
	    return false;
    }
	
	
	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,1};
		ContainsDuplicateII_219 new1 = new ContainsDuplicateII_219();
	    
	    long startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��  
	    for (int i = 0; i < 10000; i++) {
	    	new1.containsNearbyDuplicate(nums, 3);
		}
		long endTime=System.currentTimeMillis(); //��ȡ����ʱ��  
	    System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ms"); 
	    
	    startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��  
	    for (int i = 0; i < 10000; i++) {
	    	new1.containsNearbyDuplicate1(nums, 3);
		}
		endTime=System.currentTimeMillis(); //��ȡ����ʱ��  
	    System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ms");
	}

}
