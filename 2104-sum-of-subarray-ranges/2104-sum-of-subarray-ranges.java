class Solution {
    public long subArrayRanges(int[] nums) {
        return maxSum(nums) - minSum(nums);
    }

     private long minSum(int[] arr){
        Deque<long[]> st = new ArrayDeque<>();

        long currentSum = 0;
        long answer = 0;

        for (int i = 0; i < arr.length; i++) {

            long range = 1;

            while (!st.isEmpty() && st.peek()[0] > arr[i]) {

                long[] popped = st.pop();

                range += popped[1];
                currentSum -= popped[2];
            }

            long contribution = (long) arr[i] * range;

            st.push(new long[] {
                    arr[i],
                    range,
                    contribution
            });

            currentSum += contribution;

            answer = (answer + currentSum);
        }

        return answer;
    }
     private long maxSum(int[] arr){
        Deque<long[]> st = new ArrayDeque<>();

        long currentSum = 0;
        long answer = 0;

        for (int i = 0; i < arr.length; i++) {

            long range = 1;

            while (!st.isEmpty() && st.peek()[0] < arr[i]) {

                long[] popped = st.pop();

                range += popped[1];
                currentSum -= popped[2];
            }

            long contribution = (long) arr[i] * range;

            st.push(new long[] {
                    arr[i],
                    range,
                    contribution
            });

            currentSum += contribution;

            answer = (answer + currentSum);
        }

        return answer;
}
}