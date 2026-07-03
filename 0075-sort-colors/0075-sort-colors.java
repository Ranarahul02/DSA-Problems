class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;

        for(int num : nums){
            if(num == 0) red++;
            else if(num == 1) white++;
            else blue++;
        }
        int idx = 0;
        while(red>0){
            nums[idx++]=0;
            red--;
        }

        while(white>0) {
            nums[idx++]=1;
            white--;
        }

        while(blue>0){
            nums[idx++]=2;
            blue--;
        }
    }
}