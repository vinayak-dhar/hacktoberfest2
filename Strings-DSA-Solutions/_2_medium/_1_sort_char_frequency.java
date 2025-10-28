package _7_string._2_medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Sort Characters By Frequency
// Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

// Return the sorted string. If there are multiple answers, return any of them.

 

// Example 1:

// Input: s = "tree"
// Output: "eert"
// Explanation: 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// Example 2:

// Input: s = "cccaaa"
// Output: "aaaccc"
// Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Example 3:

// Input: s = "Aabb"
// Output: "bbAa"
// Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.
 


public class _1_sort_char_frequency {
    // 1st method -> using HashMap 
    // TC -> O(n) + O(klog(k)) + O(n)
    static String frequencySort(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) { // O(n)
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.getValue(),a.getValue())
        );
        pq.addAll(mp.entrySet()); // O(log(k))
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character,Integer> entry = pq.poll(); // O(klog(k)) -> pq.poll() if of O(log(k)) and it is done k times
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue())); // O(n)
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}
