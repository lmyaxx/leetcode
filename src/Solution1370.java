public class Solution1370 {
    public String sortString(String s) {
        int[] count = new int[26];
        int total = s.length();
        for(char ch : s.toCharArray()){
            count[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while(total>0){
            for(int i = 0; i < 26; i++){
                if(count[i] > 0){
                    count[i]--;
                    total--;
                    sb.append((char)('a' + i));
                }
            }
            for(int i = 26; i >= 0; i--){
                if(count[i] > 0){
                    count[i]--;
                    total--;
                    sb.append((char)('a' + i));
                }
            }
        }
        return sb.toString();
    }
}
