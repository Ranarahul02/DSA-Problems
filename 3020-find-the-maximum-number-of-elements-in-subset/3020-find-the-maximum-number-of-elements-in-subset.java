class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        int max = 1;

        if(map.containsKey(1)){
            int ones = map.get(1);
            if(ones%2==0) ones--;
            max = Math.max(max, ones);
        }

        for(int num : map.keySet()){
            if(num==1) continue;

            int ans = 0;
            long curr = num;

            while(curr <= 1000000000L && map.getOrDefault((int)curr, 0) >= 2){
                ans += 2;
                curr *= curr;
            }

            if(curr <= 1000000000L && map.getOrDefault((int)curr, 0) > 0) ans += 1;
            else ans -= 1;

            max = Math.max(max, ans);
        }
        return max;
    }
}