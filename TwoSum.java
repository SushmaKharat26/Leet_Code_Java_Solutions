/*
LeetCode Problem: 1. Two Sum
Link: https://leetcode.com/problems/two-sum/description/
Difficulty: Easy
Solution Explanation:
This solution uses two nested loops to check every possible pair in the array.
If the sum of a pair equals the target, it returns their indices immediately.
*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {}; 
    }
}
