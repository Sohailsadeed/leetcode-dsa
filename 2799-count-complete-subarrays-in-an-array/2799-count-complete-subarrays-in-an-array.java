class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int r = 0, l = 0, count = 0;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int formed = 0;
        for(int i = 0 ; i < nums.length ; i++)
            set.add(nums[i]);

        while( r < nums.length)
        {   
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            if(map.get(nums[r]) == 1){
                formed++;
            }
                
            while(formed == set.size())
              { 
                  if(formed == set.size())
                      count += nums.length - r;
                  map.put(nums[l], map.get(nums[l]) - 1);
                  if(map.get(nums[l]) == 0)
                  {
                    formed--;
                    map.remove(nums[l]);
                  }
                  l++;
              }
              r++;
        }
        return count;
    }
}