class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int r = 0, l = 0, len = 0, j = 0, maxEle = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        while(r < nums.length)
        {   
           if(!dq.isEmpty() && dq.peekLast() <= r - k){
            dq.pollLast();
           }
           while(!dq.isEmpty() && nums[dq.peekFirst()] <= nums[r])
            dq.pollFirst();
           dq.push(r);
           if(r >= k - 1)
            res.add(nums[dq.peekLast()]);
           r++;
  
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}