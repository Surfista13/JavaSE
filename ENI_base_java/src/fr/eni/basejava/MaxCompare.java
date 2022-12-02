package fr.eni.basejava;

public class MaxCompare {

	private static int compare(int num1, int num2) {
		int x = Math.max(num1, num2);
		return x;
	}
	
	private static int compare2(int num1, int num2) {
		int y;
		y = num1 > num2 ? 1 : num1 < num2 ? -1 : 0;
		return y;
	}
	
	public static void main(String[] args) {
		
		System.out.println(compare(10,45));
		System.out.println(compare2(10,45));
	}
}
//p
