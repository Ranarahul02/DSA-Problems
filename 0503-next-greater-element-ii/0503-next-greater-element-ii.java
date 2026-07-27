class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for(int i=2*n-1; i>=0; i--){
            int num = nums[i%n];
            while(!st.isEmpty() && st.peek() <= num){
                st.pop();
            }

            if(i<n && !st.isEmpty()){
                res[i] = st.peek();
            }
            st.push(num);
        }

        return res;
    }
}