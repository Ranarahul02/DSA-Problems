class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long) m * k > n) return -1;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for(int i : bloomDay){
            low = Math.min(low, i);
            high = Math.max(high, i);
        }

        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(canMake(bloomDay, m, k, mid)){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    private static boolean canMake(int[] bloomDay, int m, int k, int day){
        int count = 0, bouquet = 0;

        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i]<=day){
                count++;

                if(count == k){
                    bouquet++;
                    count = 0;
                } 
            } else {
                count = 0;
            }
        }
        return bouquet >= m;
    }
}