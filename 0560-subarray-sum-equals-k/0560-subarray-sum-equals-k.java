class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int prefixSum = 0;
        map.put(0,1);

        for(int n : nums){
            prefixSum += n;

            if(map.containsKey(prefixSum-k)){
                count += map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}