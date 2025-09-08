class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            Set<Character> set = new HashSet<>();

            int index = i;

            while (index < s.length()) {
                curr = s.charAt(index);
                if (set.contains(curr)) {
                    break;
                }
                set.add(curr);
                index++;
            }

            max = Math.max(max, set.size());
        }

        return max;
    }
}