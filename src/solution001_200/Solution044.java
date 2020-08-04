package solution001_200;

public class Solution044 {
    public boolean isMatch(String s, String p) {
        int slen = s.length(),plen=p.length();
        boolean [][]match = new boolean[slen+1][plen+1];
        match[0][0] =true;
        for(int i=0;i<plen;i++){
            if(p.charAt(i)=='*')
                match[0][i+1] = true;
            else
                break;
        }
        for(int i=0;i<slen;i++){
            for(int j=0;j<plen;j++){
                // abc
                // a*？
                if(p.charAt(j)=='?'||p.charAt(j)==s.charAt(i)){
                    match[i+1][j+1] = match[i][j];
                }else
                // "adceb"
                // "*a*b"
                if(p.charAt(j)=='*'){
                    match[i+1][j+1] = match[i][j]||match[i+1][j]||match[i][j+1];
                }else{
                    match[i+1][j+1] = false;
                }

            }
        }
        return match[slen][plen];
    }
}
