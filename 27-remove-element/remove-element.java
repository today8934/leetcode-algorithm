class Solution {
    public int removeElement(int[] nums, int val) {
        int answer = nums.length;
        int left = 0;
        int right = nums.length - 1;

        for (int num: nums) {
            if (num == val) {
                answer = answer - 1;
            }
        }

        while (left < right) {
            if (nums[left] == val) {
                if (nums[right] == val) {
                    right = right - 1;
                    continue;
                }

                nums[left] = nums[right];
                right = right - 1;
            }

            left = left + 1;
        }
        

        return answer;
    }
}