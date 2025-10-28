package _7_string._2_medium;

// Maximum Nesting Depth of the Parentheses
// Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

 

// Example 1:

// Input: s = "(1+(2*3)+((8)/4))+1"

// Output: 3

// Explanation:

// Digit 8 is inside of 3 nested parentheses in the string.

// Example 2:

// Input: s = "(1)+((2))+(((3)))"

// Output: 3

// Explanation:

// Digit 3 is inside of 3 nested parentheses in the string.

// Example 3:

// Input: s = "()(())((()()))"

// Output: 3

 

public class _2_max_nesting_depth_parantheses {
    static int maxDepth(String s) {
        int maxDepth = 0;
        int cntDepth = 0;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                cntDepth++;
            }
            else if (ch == ')') {
                maxDepth = Math.max(maxDepth,cntDepth);
                cntDepth--;
            }
        }
        return maxDepth;
    }
    public static void main(String[] args) {
        String s = "()(())(((())()))";
        System.out.println(maxDepth(s));
    }
}
