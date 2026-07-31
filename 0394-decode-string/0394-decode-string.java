class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(c != ']'){
                st.push(c);
            } else {
                StringBuilder str = new StringBuilder();

                while(st.peek() != '['){
                    str.insert(0,st.pop());
                }

                st.pop();

                StringBuilder num = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    num.insert(0, st.pop());
                }

                int repeat = Integer.parseInt(num.toString());

                StringBuilder repeated = new StringBuilder();

                for(int i=0; i<repeat; i++){
                    repeated.append(str);
                }

                for(char ch : repeated.toString().toCharArray()){
                    st.push(ch);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.insert(0, st.pop());
        }
        return res.toString();
    }
}