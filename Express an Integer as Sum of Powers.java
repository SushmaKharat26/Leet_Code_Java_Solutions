/*
LeetCode Problem: 2787. Ways to Express an Integer as Sum of Powers
Link: https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/
Difficulty: Medium
Solution Explanation:
This solution uses dynamic programming to count the number of ways to represent `n` as a sum of unique powers.

Approach:
1. Initialize a DP array `ways` where ways[i] represents the number of ways to get sum `i`.
2. Start from power base = 1, and for each base, compute base^x.
3. Update the DP array in reverse to avoid counting the same base multiple times.
4. Use modulo (10^9 + 7) to prevent overflow.

Time Complexity: O(n * sqrt(n)) (since base^x grows quickly)
Space Complexity: O(n)
*/

public class NumberOfWays {

    private static final int MODULO = 1_000_000_007;

    public int countWays(int total, int power) {
        long[] ways = new long[total + 1];
        ways[0] = 1; // Base case: 1 way to get sum = 0

        for (int base = 1; Math.pow(base, power) <= total; base++) {
            int value = (int) Math.pow(base, power);
            for (int sum = total; sum >= value; sum--) {
                ways[sum] = (ways[sum] + ways[sum - value]) % MODULO;
            }
        }
        return (int) ways[total];
    }

    public static void main(String[] args) {
        NumberOfWays solver = new NumberOfWays();
        System.out.println(solver.countWays(10, 2)); // Example output
    }
}
