class Solution {
    public int search(int[] nums, int target) {
        int si = 0,ei = nums.length-1;
        while(si <= ei){
            int mid = si+(ei-si)/2;
            if(target == nums[mid]){
                return mid;
            } else if(target < nums[mid]){
                ei = mid-1;
            } else {
                si = mid+1;
            }
        }
        return -1;
    }
}