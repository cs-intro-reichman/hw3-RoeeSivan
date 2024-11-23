/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		String original = "hello";
        String randomized = Anagram.randomAnagram(original);
        boolean test1 = Anagram.isAnagram("hello", "world!");
        System.out.println(test1);
		

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Handle the case for both empty strings
		if (str1.equals("") && str2.equals("")) {
			return true;
		}
	
		// Preprocess and remove spaces from both strings
		String s1 = preProcess(str1);
		String s2 = preProcess(str2);
		s1 = deleteSpaces(s1);
		s2 = deleteSpaces(s2);
	
		// If lengths are different after processing, they can't be anagrams
		if (s1.length() != s2.length()) {
			return false;
		}
	
		// Compare the characters of the strings
		int c = 0;
		int max = s1.length();
		boolean foundMatch = false;
	
		// Loop through the characters in the first string
		for (int i = 0; i < max; i++) {
			char ch1 = s1.charAt(i);
			foundMatch = false;
	
			// Loop through the characters in the second string to find a match
			for (int j = 0; j < max; j++) {
				if (s2.charAt(j) == ch1) {
					c++;
					s2 = s2.substring(0, j) + "*" + s2.substring(j + 1); // Mark this character as matched
					foundMatch = true;
					break;
				}
			}
		}
	
		// If at least one match is found and the counts are correct, it's an anagram
		return c == max;
	
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		String text = str.toLowerCase();
		String str1="";
		char currentchar;
		for(int i=0;i<text.length();i++)
		{
			currentchar = text.charAt(i);
			if((text.charAt(i)>='a' && text.charAt(i)<='z') ||(text.charAt(i)==' '))
			{
				str1+=currentchar;
			}
		}
		return str1;
	} 
	public static String deleteSpaces(String str) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				result.append(str.charAt(i));
			}
		}
		return result.toString().toLowerCase();
	}
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		int length = str.length();
		String strChange="";
		int num;
		char ch;
		while(length>0)
		{	
			num = (int) (Math.random() * length);
			ch = str.charAt(num);
			strChange = strChange+ ch;	
			length--;
			str = str.substring(0, num) + str.substring(num + 1);
		}
		return strChange;
	}
}