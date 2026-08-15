class Solution {
    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    public String reverseVowels(String s) {
        int i=0;
        int j=s.length()-1;

        char[] res = s.toCharArray();

        while(i < j){
            if(!isVowel(res[i])){
                i++;
            } else if(!isVowel(res[j])){
                j--;
            } else {
                char temp = res[i];
                res[i] = res[j];
                res[j] = temp;

                i++;
                j--;
            }
        }
        return new String(res);
    }
}