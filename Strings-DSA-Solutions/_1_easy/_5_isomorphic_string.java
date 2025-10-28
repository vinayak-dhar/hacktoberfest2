package _7_string._1_easy;

import java.util.HashMap;

// Isomorphic Strings
// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

// Example 1:

// Input: s = "egg", t = "add"

// Output: true

// Explanation:

// The strings s and t can be made identical by:

// Mapping 'e' to 'a'.
// Mapping 'g' to 'd'.
// Example 2:

// Input: s = "foo", t = "bar"

// Output: false

// Explanation:

// The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

// Example 3:

// Input: s = "paper", t = "title"

// Output: true

public class _5_isomorphic_string {
    static boolean isIsomorphic(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n1 != n2) return false;
        HashMap<Character,Character> mp = new HashMap<>();
        for (int i=0; i<n1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (!mp.isEmpty() && mp.containsKey(ch1) && mp.get(ch1) != ch2) return false;
            else if (!mp.containsKey(ch1) && mp.containsValue(ch2)) return false;
            else {
                mp.put(ch1,ch2);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "cvcv";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
    }
}
