class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }

        int left = 0;
        int right = x;
        int answer = 0;

        while (left <= right) {
            int mid = (right + left)/2;
            long square = (long)mid*mid;

            if (square == x) {
                return mid;
            }

            if (square > x) {
                right = mid - 1;
                continue;
            }

            if (square < x) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
        }

        return answer;
    }
}