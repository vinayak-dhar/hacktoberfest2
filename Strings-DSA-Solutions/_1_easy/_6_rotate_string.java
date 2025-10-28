package _7_string._1_easy;

// Rotate String
// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

// A shift on s consists of moving the leftmost character of s to the rightmost position.

// For example, if s = "abcde", then it will be "bcdea" after one shift.
 

// Example 1:

// Input: s = "abcde", goal = "cdeab"
// Output: true
// Example 2:

// Input: s = "abcde", goal = "abced"
// Output: false
 

public class _6_rotate_string {
    // 1st approach -> 
    // TC -> O(n^2) -> worst case 
    // this will fail if -> s = "defdefdefabcabc" and goal = "defdefabcabcdef"
    // static boolean rotateString(String s, String goal) {
    //     int n1 = s.length();
    //     int n2 = goal.length();
    //     if (n1 != n2) return false; // O(1)
    //     if (s == goal) return true; // O(1)
    //     StringBuilder sb = new StringBuilder();
    //     for (int i=0; i<n1; i++) { // O(n)
    //         char ch = s.charAt(i);
    //         if (ch == goal.charAt(0)) {
    //             sb.append(s.substring(i, n1)); // O(n)
    //             sb.append(s.substring(0, i)); // O(n)
    //             break;
    //         }
    //     }
    //     return sb.toString().equals(goal); // O(n)
    // }


    // 2nd approach ->
    // TC -> O(n^2)
    // static boolean rotateString(String s, String goal) {
    //     int n = s.length();
    //     int m = goal.length();
    //     if (n != m) return false; // O(1)
    //     if (s == goal) return true; // O(1)
    //     for (int i=0; i<n; i++) { // O(n)
    //         String tmp1 = s.substring(0, i); // O(n)
    //         String tmp2 = s.substring(i,n); // O(n)
    //         StringBuilder sb = new StringBuilder(tmp2 + tmp1);
    //         if (sb.toString().equals(goal)) return true; // O(n)
    //     }
    //     return false;
    // }



    // 3rd approach -> optimal solution 
    // TC -> O(n)
    static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false; // O(1)
        return (s + s).contains(goal); // O(n)
    }
    public static void main(String[] args) {
        String s = "defdefdefabcabc";
        String goal = "defdefabcabcdef";
        System.out.println(rotateString(s, goal));
    }    
}
