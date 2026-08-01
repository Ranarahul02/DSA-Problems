class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(char c : s.toCharArray()){
            if(c != '#'){
                st1.push(c);
            } else if(!st1.isEmpty()){
                st1.pop();
            }
        }
        for(char c : t.toCharArray()){
            if(c != '#'){
                st2.push(c);
            } else if(!st2.isEmpty()) {
                st2.pop();
            }
        }
        String a = "";
        String b = "";

        while(!st1.isEmpty()){
            a += st1.pop();
        }
        while(!st2.isEmpty()){
            b += st2.pop();
        }
        System.out.println(a+" "+ b);
        return a.equals(b);
    }
}