class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        int row = 0;
        String direction = "down";

        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            if ("down".equals(direction) && row == numRows - 1) {
                direction = "up";
            }

            if ("up".equals(direction) && row == 0) {
                direction = "down";
            }

            if ("down".equals(direction)) {
                sb[row].append(String.valueOf(s.charAt(i)));
                row = row + 1;
            } else {
                sb[row].append(String.valueOf(s.charAt(i)));
                row = row - 1;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (StringBuilder stringBuilder: sb) {
            answer.append(stringBuilder);
        }
        return answer.toString();
    }
}