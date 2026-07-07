class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int pref[] = new int[n];
        pref[0] = nums[0];
        int suff[] = new int[n];
        suff[n-1] = nums[n-1];

        for(int i=1;i<n;i++){
            pref[i] = pref[i-1]+nums[i];
            suff[n-i-1] = suff[n-i]+nums[n-i-1];
        }
        
        for(int i=0;i<n;i++){
            if(pref[i]==suff[i]) return i;
        }
        
        return -1;
    }
}