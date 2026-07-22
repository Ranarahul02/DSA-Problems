class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(st.isEmpty() || st.peek() != c){
                st.push(c);
            } else {
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}