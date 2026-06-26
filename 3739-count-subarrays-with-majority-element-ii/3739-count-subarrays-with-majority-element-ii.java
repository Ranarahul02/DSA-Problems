class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int len = 2*n+2;

        long[] countAtSum = new long[len];
        long[] countBelowTheSum = new long[len];

        int idx = n+1;
        countAtSum[idx] = 1;
        countBelowTheSum[idx] = 1;

        long ans = 0;
        for(int num : nums){
            if(num == target) idx++;
            else idx--;

            countAtSum[idx]++;
            ans += countBelowTheSum[idx-1];
            countBelowTheSum[idx] = countBelowTheSum[idx-1]+countAtSum[idx];
        }
        return ans;
    }
}