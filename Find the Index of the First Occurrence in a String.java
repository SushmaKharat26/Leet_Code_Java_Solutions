/*
LeetCode Problem: 28. Find the Index of the First Occurrence in a String
Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
Difficulty: Easy
Solution Explanation:
We check each possible starting index in haystack where needle could fit.
If a match is found, return the index; otherwise, return -1.

Approach:
1. Get lengths of haystack and needle.
2. Loop from 0 to (n - m) inclusive.
3. At each step, compare substring of haystack with needle.
4. Return the index if match found, else return -1.

Time Complexity: O((n-m+1) * m) in worst case.
Space Complexity: O(1)
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m > n) return -1;

        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
