package _7_string._2_medium;

// Longest Palindromic Substring
// Given a string s, return the longest palindromic substring in s.

 

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"

public class _6_longest_palindromic_substring {


    // brute force solution : TC -> O(n^3) -> n for string s traversal, and n for making substrings of that string, n for reversing the string check whether it is palindrome
    


    static String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }

    // optimal solution :
    // TC -> O(n * (n + n)) -> n - for i to s length, n - for left to 0 and right to s length, n - for using substring function
    // TC -> O(n^2)
    // SC -> O(n)
    static String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        String maxStr = s.substring(0, 1);
        for (int i=0; i<s.length(); i++) {
            String odd = expandFromCenter(s,i,i);
            String even = expandFromCenter(s,i,i+1);
            if (odd.length() > maxStr.length()) maxStr = odd;
            if (even.length() > maxStr.length()) maxStr = even;
        }
        return maxStr;
    }
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
