class Solution {
    
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int tmp = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(prev, tmp + nums[i]);
            tmp = prev;
            prev = current;
        }
        
        return prev;
    }
}