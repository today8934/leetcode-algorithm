class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        
        Integer[] tmp = new Integer[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = i;
        }
        
        Arrays.sort(tmp, (a, b) -> score[b] - score[a]);
        
        for (int rank = 0; rank < n; rank++) {
            int origin = tmp[rank];
            if (rank == 0) {
                result[origin] = "Gold Medal";
            } else if (rank == 1) {
                result[origin] = "Silver Medal";
            } else if (rank == 2) {
                result[origin] = "Bronze Medal";
            } else {
                result[origin] = String.valueOf(rank + 1);
            }
        }
        
        return result;
    }
}