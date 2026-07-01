class Solution {
    public int maxDistance(String moves) {
        int i = 0;
        int j = 0;
        int extraCount = 0;

        for(char c : moves.toCharArray()){
            if(c == 'U'){
                j++;
            } else if(c == 'D'){
                j--;
            } else if(c == 'L'){
                i--;
            } else if(c == 'R'){
                i++;
            } else {
                extraCount++;
            }
        }
        return Math.abs(i)+Math.abs(j)+extraCount;
    }
}