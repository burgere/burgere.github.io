//Eric Burger
//Homework 1 - CSC 301
//Part A - StringRec.java
package homework;

public class StringRec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reversePrint("");
		reversePrint("word");
		System.out.println(isPalindromeByRec("asadf"));
		reversePrint("orbra");
		System.out.println(isPalindromeByRec("orbra"));
		System.out.println(isPalindromeByRec(""));
	}
	
	public static void reversePrint(String s)
	{
		printReverse(s, s.length() - 1);
	}
	
	public static void printReverse(String theString, int i)
	{
		if (i < 0)
			return;
		else
		{
			System.out.println(theString.charAt(i));
			printReverse(theString, i - 1);
		}
	}
	public static boolean isPalindromeByRec(String s)
	{
		if (s.length() == 0)
		{
			return true;
		}
		return printPalindrome(s, 0, s.length() - 1);
	}
	
	public static boolean printPalindrome(String theString, int start, int end)
	{
		String theNewString = theString.toLowerCase();
		if (start == end)
		{
			return true;
		}
		else if (theNewString.charAt(start) != theNewString.charAt(end))
		{
			return false;
		}
		else
		{
			printPalindrome(theNewString, start + 1, end - 1);
		}
		return true;
	}

}
