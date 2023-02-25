public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        String longest = "";
        for (int i = 0; i < n; i++) {
            //Odd string
            String palindromeOdd = expandAroundCenter(s, i, i);
            if (palindromeOdd.length() > longest.length()) {
                longest = palindromeOdd;
            }
            String palindromeEven = expandAroundCenter(s, i, i + 1);
            //Even string
            if (palindromeEven.length() > longest.length()) {
                longest = palindromeEven;
            }
        }
        return longest;
    }
    
    public static String expandAroundCenter(String s, int left, int right) {
        int n = s.length();

        //General Palindrome logic
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
    public static void main(String[] args) {
        String s = "babad";
        String longestPalindrome = LongestPalindrome.longestPalindrome(s);
        System.out.println("Longest palindrome: " + longestPalindrome);
    }
    

}    

