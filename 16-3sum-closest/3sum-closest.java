class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int answer = Integer.MAX_VALUE;
        int bestDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i;
            int mid = i + 1;
            int right = nums.length - 1;

            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];

                if (sum == target) {
                    return sum;
                }

                if (sum < target) {
                    mid++;
                }

                if (sum > target) {
                    right--;
                }

                if (bestDiff > Math.abs(target - sum)) {
                    answer = sum;
                    bestDiff = Math.abs(target - sum);
                }
                
            }
        }

        return answer;
    }
}