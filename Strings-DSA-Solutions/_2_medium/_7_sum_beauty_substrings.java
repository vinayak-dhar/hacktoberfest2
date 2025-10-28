package _7_string._2_medium;

// Sum of Beauty of All Substrings
// The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

// For example, the beauty of "abaacc" is 3 - 1 = 2.
// Given a string s, return the sum of beauty of all of its substrings.

 

// Example 1:

// Input: s = "aabcb"
// Output: 5
// Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
// Example 2:

// Input: s = "aabcbaa"
// Output: 17

public class _7_sum_beauty_substrings {
    // brute force -> in this we need to find the maximum frequency of a character and subtract it to the minimum frequency of a character then if the ans is greater than 0 it is beautifull
    // TC -> O(n^2)
    // SC -> O(1)
    static int beautySum(String s) {
        int n = s.length();
        int sum = 0;
        for (int i=0; i<n; i++) {
            int[] freq = new int[26];
            for (int j=i; j<n; j++) {
                freq[s.charAt(j) - 'a']++;
                int maxfreq = Integer.MIN_VALUE;
                int minfreq = Integer.MAX_VALUE;
                for (int k=0; k<26; k++) {
                    if (freq[k] > 0) {
                        maxfreq = Math.max(maxfreq, freq[k]);
                        minfreq = Math.min(minfreq, freq[k]);
                    }
                }
                sum += Math.abs(maxfreq - minfreq);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        String s = "aabcbaa";
        System.out.println(beautySum(s));
    }
}
