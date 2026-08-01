class Solution {
    public int minAddToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            int len = sb.length();

            if(len > 0){
                char last = sb.charAt(len-1);

                if(last == '(' && ch == ')'){
                    sb.deleteCharAt(len-1);
                    continue;
                }
            }
            sb.append(ch);
        }
        return sb.length();
    }
}