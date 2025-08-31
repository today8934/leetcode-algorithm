class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }

        int bestStart = 0;
        int bestLen = 1;

        for (int center = 0; center < n; center++) {
            int[] odd = expand(s, center, center);
            if (odd[1] > bestLen) {
                bestStart = odd[0];
                bestLen = odd[1];
            }

            int[] even = expand(s, center, center + 1);
            if (even[1] > bestLen) {
                bestStart = even[0];
                bestLen = even[1];
            }
        }

        String answer = s.substring(bestStart, bestStart + bestLen);
        return answer;
    }

    private int[] expand(String s, int leftStart, int rightStart) {
        int left = leftStart;
        int right = rightStart;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        int start = left + 1;
        int length = right - left - 1;

        int[] result = new int[2];
        result[0] = start;
        result[1] = length;

        return result;
    }
}