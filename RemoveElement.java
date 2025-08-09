/*
LeetCode Problem: 27. Remove Element
Link: https://leetcode.com/problems/remove-element/description/
Difficulty: Easy
Solution Explanation:
This solution uses a single pointer to overwrite elements equal to val with the next non-val elements.
It iterates once through the array, placing valid elements at the start, and returns the count of such elements.
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // pointer for position of non-val elements
        for (int num : nums) {
            if (num != val) {
                nums[k++] = num;
            }
        }
        return k;
    }
}

