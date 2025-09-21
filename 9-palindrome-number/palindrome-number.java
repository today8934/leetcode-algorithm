class Solution {
    public boolean isPalindrome(int x) {
        String stringX = String.valueOf(x);

        int mid = stringX.length()/2;
        int left = 0;
        int right = 0;

        if (stringX.length()%2 == 0) {
            right = mid;
            left = mid - 1;
        } else {
            left = mid - 1;
            right = mid + 1;
        }

        while (left >= 0) {
            if (stringX.charAt(left) != stringX.charAt(right)) {
                return false;
            }
            left = left - 1;
            right = right + 1;
        }

        return true;
    }
}