class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int max = 0;
        int n = nums.length;

        for(int right=0; right<n; right++){
            if(nums[right]==0){
                zeroCount++;
            }

            while(zeroCount > k){
                if(nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}