class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int si = 0, ei = n-1;
        int min = Integer.MAX_VALUE;

        while(si <= ei){
            int mid = si+(ei-si)/2;

            if(nums[si] <= nums[mid]){
                min = Math.min(min, nums[si]);
                si = mid+1;
            } else {
                min = Math.min(min, nums[mid]);
                ei = mid-1;
            }
        }
        return min;
    }
}