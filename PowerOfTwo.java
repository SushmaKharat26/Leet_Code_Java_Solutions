/*
LeetCode Problem: 231. Power of Two
Link: https://leetcode.com/problems/power-of-two/description/
Difficulty: Easy
Solution Explanation:
This solution checks if n is greater than 0 and uses the property that powers of two have only one bit set.
The expression (n & (n - 1)) == 0 confirms this property in constant time without loops or recursion.
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

