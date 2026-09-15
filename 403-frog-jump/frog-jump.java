import java.util.*;

class Solution {

    public boolean canCross(int[] stones) {

        int n = stones.length;

        
        Set<Integer>[] dp = new HashSet[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashSet<>();
        }

        dp[0].add(0);

        for (int i = 0; i < n; i++) {

            for (int k : dp[i]) {

                for (int jump = k - 1;
                     jump <= k + 1;
                     jump++) {

                    if (jump <= 0) {
                        continue;
                    }

                    int nextPosition = stones[i] + jump;

                    int nextIndex = Arrays.binarySearch(
                        stones, nextPosition
                    );

                    if (nextIndex != -1 &&
                        nextIndex >= 0) {

                        if (nextIndex == n - 1) {
                            return true;
                        }

                        dp[nextIndex].add(jump);
                    }
                }
            }
        }

        return false;
    }
}