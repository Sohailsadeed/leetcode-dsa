class Solution {
    public int maximalRectangle(char[][] matrix) {
        Deque<Integer> st = new ArrayDeque<>();
        int maximumArea = 0;
        int[] heights = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                    continue;
                }
                heights[j]++;

            }
            for (int k = 0; k < heights.length; k++) {

                while (!st.isEmpty() && heights[k] < heights[st.peek()]) {
                    int element = heights[st.pop()];
                    int nse = k;
                    int pse = st.isEmpty() ? -1 : st.peek();

                    maximumArea = Integer.max(maximumArea, element * (nse - pse - 1));
                }
                st.push(k);
            }
            while (!st.isEmpty()) {
                int element = heights[st.pop()];
                int nse = heights.length;
                int pse = st.isEmpty() ? -1 : st.peek();

                maximumArea = Integer.max(maximumArea, element * (nse - pse - 1));
            }
        }
        return maximumArea;
    }
}