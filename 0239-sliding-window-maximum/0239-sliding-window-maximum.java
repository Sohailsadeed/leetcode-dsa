class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> window = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        int r = 0, l = 0, len = 0, j = 0, maxEle = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        while(r < nums.length)
        {
            pq.add(r);
            window.add(nums[r]);
            while(pq.peek() < l){
                pq.poll();
            }
            if(window.size() == k){
            maxEle = nums[pq.peek()];
            res.add(maxEle);
            window.removeFirst();
            l++;
            }
            r++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}