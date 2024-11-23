

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		System.out.println(isAnagram("hello","world!"));
		

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

		if (str1.equals("") && str2.equals("")) return true;
		int c=0;
		String s1 = preProcess(str1);
		String s2 = preProcess(str2);

		int max = Math.max(s1.length(),s2.length());
		int min = Math.min(s1.length(),s2.length());
		char ch1,ch2;
		boolean equals=false;//default value false;
		for(int i=0;i<s1.length();i++)
		{
			ch1=s1.charAt(i);
			for(int j=0;j<s2.length();j++)
			{
				ch2 = s2.charAt(j);
				if(ch1==ch2)
				{
					equals= true;
					c++;
				}
			}
		}
		if(c%2==0) 
		{
		return true;
		}
		else
		return false;
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
			if((text.charAt(i)>='a' && text.charAt(i)<='z'))
			{
				str1+=currentchar;
			}
		}
		return str1;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		int length = str.length();
		String strChange="";
		int num;
		char ch;
		for(int i =0;i<length;i++)
		{
			num = (int) (Math.random() * length);
			ch = str.charAt(num);
			str = str.substring(0, num) + str.substring(num + 1);
			strChange = strChange+ ch;	
		}
		return strChange;
	}
}
