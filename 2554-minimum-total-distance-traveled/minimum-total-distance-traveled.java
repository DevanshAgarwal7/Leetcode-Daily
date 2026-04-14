class Solution {
    public long minimumTotalDistance(List<Integer> robots, int[][] factories) {
        Collections.sort(robots);
        Arrays.sort(factories, (a, b) -> a[0] - b[0]);

        final int numberOfRobots = robots.size();
        long[] dp = new long[numberOfRobots + 1];
        Arrays.fill(dp, 200000000000L);
        dp[0] = 0;

        for(int[] factory: factories){
            int position = factory[0];
            for(int capacity = factory[1]; capacity != 0; --capacity){
                for(int robot = numberOfRobots; robot > 0; --robot){
                    dp[robot] = Math.min(dp[robot], Math.abs(robots.get(robot - 1) - position) + dp[robot - 1]);
                }
            }
        }
        return dp[numberOfRobots];
    }
}