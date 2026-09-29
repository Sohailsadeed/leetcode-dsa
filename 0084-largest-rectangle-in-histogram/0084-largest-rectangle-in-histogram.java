class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int element = heights[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                
                maxArea = Integer.max(maxArea, element * (nse - pse - 1));
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            int element = heights[st.pop()];
            int nse = heights.length;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Integer.max(maxArea, element * (nse - pse - 1));
            
        } 
        return maxArea;
    }
}