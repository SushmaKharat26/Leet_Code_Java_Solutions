/*
LeetCode Problem: 2439. Product Queries of Powers of Two
Link: https://leetcode.com/problems/product-queries-of-powers-of-two/
Difficulty: Medium
Solution Explanation:
1. Extract all powers of two that sum to 'n' using its binary representation.
2. Store these in the `powers` array in increasing order.
3. Build a prefix product array to quickly calculate product of ranges.
4. Use modular inverse to perform division under modulo for query results.
5. Fast exponentiation is used for modular inverse calculation.
Time Complexity: O(31 + Q * log MOD), where Q = number of queries.
*/

import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Build powers array from binary representation of n
        List<Long> powers = new ArrayList<>();
        for (int bit = 0; bit < 31; bit++) {
            if ((n & (1 << bit)) != 0) {
                powers.add(1L << bit);
            }
        }

        // Step 2: Build prefix product array modulo MOD
        int len = powers.size();
        long[] prefixProd = new long[len + 1];
        prefixProd[0] = 1;
        for (int i = 0; i < len; i++) {
            prefixProd[i + 1] = (prefixProd[i] * powers.get(i)) % MOD;
        }

        // Step 3: Answer queries using modular division (modular inverse)
        int qLen = queries.length;
        int[] ans = new int[qLen];
        for (int i = 0; i < qLen; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long prod = prefixProd[r + 1] * modInverse(prefixProd[l], MOD) % MOD;
            ans[i] = (int) prod;
        }
        return ans;
    }

    // Modular inverse using fast exponentiation
    private long modInverse(long x, long mod) {
        return modPow(x, mod - 2, mod);
    }

    private long modPow(long base, long exp, long mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
