package leetCode;

public class PowerOfThree_326 {

	public boolean isPowerOfThree(int n) {
		return ( n>0 &&  1162261467%n==0);
    }
	
	public static void main(String[] args) {
		PowerOfThree_326 n1 = new PowerOfThree_326();
		
		System.out.println(n1.isPowerOfThree(0));
		System.out.println(n1.isPowerOfThree(1));
		System.out.println(n1.isPowerOfThree(3));
		System.out.println(n1.isPowerOfThree(8));
		System.out.println(n1.isPowerOfThree(27));
	}
}
