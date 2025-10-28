package _7_string._2_medium;

// Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without duplicate characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

public class _5_count_substrings {
    // optimal solution -> hash table, sliding window
    // TC -> O(n)
    // SC -> O(1)
    static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] charCount = new int[3];
        int count = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            charCount[s.charAt(right) - 'a']++;
            while (charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0) {
                count += n - right;
                charCount[s.charAt(left++) - 'a']--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "aaacb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
