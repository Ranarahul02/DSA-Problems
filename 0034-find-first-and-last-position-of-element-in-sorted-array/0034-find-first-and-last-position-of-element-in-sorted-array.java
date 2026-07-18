class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOcc = first(nums, target);
        int lastOcc = last(nums, target);
        return new int[]{firstOcc, lastOcc};
    }
    private int first(int[] nums, int target){
        int i=0, j=nums.length-1;
        int first = -1;
        while(i <= j){
            int mid = i+(j-i)/2;
            if(nums[mid] == target){
                first = mid;
                j = mid-1;
            } else if(nums[mid] < target){
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        return first;
    }
    private int last(int[] nums, int target){
        int i=0, j=nums.length-1;
        int last = -1;
        while(i <= j){
            int mid = i+(j-i)/2;
            if(nums[mid] == target){
                last = mid;
                i = mid+1;
            } else if(nums[mid] < target){
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        return last;
    }
}