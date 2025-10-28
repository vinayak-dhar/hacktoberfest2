package _7_string._1_easy;

import java.util.HashMap;

// Valid Anagram
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

// Example 1:

// Input: s = "anagram", t = "nagaram"

// Output: true

// Example 2:

// Input: s = "rat", t = "car"

// Output: false

public class _7_valid_anagram {
    static boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n != m) return false;
        if (s == t) return true;
        HashMap<Character,Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        for (char ch : t.toCharArray()) {
            if (!mp.containsKey(ch)) return false;
            else {
                mp.put(ch,mp.get(ch) - 1);
            }
        }
        int sum = 0;
        for (Character ch : mp.keySet()) {
            sum += mp.get(ch);
        }
        return sum == 0;
    }
    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        System.out.println(isAnagram(s, t));
    }
}
