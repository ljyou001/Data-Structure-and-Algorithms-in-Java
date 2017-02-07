import java.util.Scanner;

public class Palindrome {
	
	public static boolean check(String str) {
		boolean result = true;
		
		// Add your code here
		for(int i=0; i<str.length()/2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str;
		System.out.println("Please input words one-by-one to find palindromes:");
		while(!(str = scanner.nextLine()).equalsIgnoreCase("exit")) {
			if (check(str))
				System.out.println(String.format("\"%s\" is a palindrome.", str));
			else
				System.out.println(String.format("\"%s\" is not a palindrome.", str));
		}
		System.out.println("Bye bye");
		scanner.close();
	}
}
