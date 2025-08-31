class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    List<Integer> triple = new ArrayList<Integer>();
                    triple.add(nums[i]);
                    triple.add(nums[left]);
                    triple.add(nums[right]);
                    result.add(triple);

                    int leftValue = nums[left];
                    int rightValue = nums[right];

                    while (left < right && nums[left] == leftValue) {
                        left++;
                    }

                    while (left < right && nums[right] == rightValue) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}