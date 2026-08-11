class Solution {
    public int searchInsert(int[] nums, int target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num: nums) {
            pq.offer(num);
        }

        int index = 0;
        int answer = 0;
        while (true) {
            if (pq.isEmpty()) {
                answer = nums.length;
                return answer;
            }

            int num = pq.poll();
            if (num == target || num > target) {
                answer = index;
                return answer;
            }

            index++;
        }
    }
}