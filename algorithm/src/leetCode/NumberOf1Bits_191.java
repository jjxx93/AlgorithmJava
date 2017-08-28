package leetCode;

public class NumberOf1Bits_191 {
	
	public int hammingWeight(int n) {
		int sum = 0;
		String str = Integer.toBinaryString(n);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				sum++;
			}
		}
		return sum;
    }
	
	public static void main(String[] args) {
		NumberOf1Bits_191 new1 = new NumberOf1Bits_191();
		
		System.out.println(new1.hammingWeight(11));
		System.out.println(Integer.hashCode(10));
		
	}
}
