/**
 * @Author : Chad li
 * @Date : 2020/2/21 18:22
 * @Version 1.0
 */
public class Solution394 {
    public String decodeString(String s) {
        int[] pos = new int[1];
        return helper(s,pos);
    }

    private String helper(String s, int[] pos){
        StringBuilder sb = new StringBuilder();
        while(true){
            if(pos[0]>=s.length()||s.charAt(pos[0]) == ']'){
                pos[0]++;
                return sb.toString();
            }
            if(s.charAt(pos[0])<='9'&&s.charAt(pos[0])>='0'){
                int num = s.charAt(pos[0]) - '0';
                pos[0]++;
                while(s.charAt(pos[0])<='9'&&s.charAt(pos[0])>='0'){
                    num = num * 10 + s.charAt(pos[0]) - '0';
                    pos[0]++;
                }
                // s.charAt(pos[0]) must be ']', so skip it.
                pos[0]++;
                String ns = helper(s,pos);
                while(num-->0){
                    sb.append(ns);
                }
                continue;
            }
            sb.append(s.charAt(pos[0]));
            pos[0]++;
        }
    }
}
