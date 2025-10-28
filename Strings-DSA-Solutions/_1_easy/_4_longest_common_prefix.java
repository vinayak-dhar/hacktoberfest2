package _7_string._1_easy;

// Longest Common Prefix
// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

 

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

public class _4_longest_common_prefix {
    // TC -> O(n * m) -> worst case
    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String pref = strs[0];
        int preflen = pref.length();
        for (int i=0; i<strs.length; i++) { // TC -> O(n)
            String s = strs[i];
            while (preflen > s.length() || !pref.equals(s.substring(0,preflen))) { // TC -> O(m)
                preflen--;
                if (preflen == 0) return "";
                pref = pref.substring(0, preflen);
            }
        }
        return pref;
    }
    public static void main(String[] args) {
        String[] strs = {"carrace","caracecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
