class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[] {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        boolean isStartFounded = false;
        boolean isEndFounded = false;

        if (nums.length == 0) return answer;

        while (left <= right) {
            if (nums[left] == target && !isStartFounded) {
                isStartFounded = true;
                answer[0] = left;
            }
                
            if (!isStartFounded) left++;

            if (nums[right] == target && !isEndFounded) {
                isEndFounded = true;
                answer[1] = right;
            }
                
            if (!isEndFounded) right--;
            if (isStartFounded && isEndFounded) break;
        }

        return answer;
    }
}