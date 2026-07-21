class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        for(int k : map.keySet()){
            if(map.get(k) > len/2) return k;
        }
        return -1;
    }
}