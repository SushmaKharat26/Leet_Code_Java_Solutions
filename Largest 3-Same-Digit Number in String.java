/*
LeetCode Problem: 2264. Largest 3-Same-Digit Number in String
Link: https://leetcode.com/problems/largest-3-same-digit-number-in-string/
Difficulty: Easy
Solution Explanation:
We scan the string for substrings of length 3 that consist of the same digit.
We keep track of the lexicographically largest such substring.

Approach:
1. Iterate through the string from index 0 to length - 3.
2. Extract each substring of length 3.
3. If all three characters are equal and the substring is larger than the current max, update the max.
4. Return the largest found or an empty string if none exist.

Time Complexity: O(n), where n is the length of the string.
Space Complexity: O(1)
*/

class Solution {
    public String largestGoodInteger(String num) {
        String max = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            String sub = num.substring(i, i + 3);
            if (sub.charAt(0) == sub.charAt(1) && sub.charAt(1) == sub.charAt(2)) {
                if (max.equals("") || sub.compareTo(max) > 0) {
                    max = sub;
                }
            }
        }
        return max;
    }
}
