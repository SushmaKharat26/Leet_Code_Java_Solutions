/*
LeetCode Problem: 26. Remove Duplicates from Sorted Array
Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
Difficulty: Easy
Solution Explanation:
1. Since the array is sorted, duplicates will be adjacent.
2. Use a two-pointer approach:
   - Pointer `i` tracks the position of the last unique element.
   - Pointer `j` iterates through the array.
3. If nums[j] is different from nums[i], increment i and assign nums[i] = nums[j].
4. Return i + 1 as the number of unique elements.
Time Complexity: O(n) — Each element is visited once.
Space Complexity: O(1) — In-place modification.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // Pointer to track unique elements
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1; 
    }
}
