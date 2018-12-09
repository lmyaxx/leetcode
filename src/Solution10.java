import org.junit.Test;

public class Solution10 {

    @Test
    public void test1(){
        System.out.println(isMatch("aaa","ab*a*c*a"));
    }
    public boolean isMatch(String s, String p) {
        int slen = s.length(),plen=p.length();
        //dp[i][j]，i表示s取长，j表示p取长
        boolean [][] dp= new boolean[slen+1][plen+1];
        //两者都为0时，为true
        dp[0][0]=true;
        //s不为空，p为空
        for(int sOfDp=1;sOfDp<=slen;sOfDp++){
            dp[sOfDp][0] = false;
        }
        //s为空，只有形如a*b*才可以生效
        for(int pOfDp=1;pOfDp<=plen;pOfDp++){
            if(p.charAt(pOfDp-1)=='*')
                dp[0][pOfDp] = dp[0][pOfDp-2];
            else
                dp[0][pOfDp] = false;
        }
        for(int sOfDp=1;sOfDp<=slen;sOfDp++){
            for(int pOfDp=1;pOfDp<=plen;pOfDp++){
                //s与p的最后一个字母相同
                if(p.charAt(pOfDp-1)=='.'||p.charAt(pOfDp-1)==s.charAt(sOfDp-1)){
                    dp[sOfDp][pOfDp]= dp[sOfDp-1][pOfDp-1];
                }else if(p.charAt(pOfDp-1)!='*') {
                    //不同且不为 *
                    dp[sOfDp][pOfDp]=false;
                }else {
                    //s当前字母与p的前一个字母相同，则向前放缩，放缩应尽量小
                    //形如aaa，a*，比较aa，a*，比较a，a*，比较 空，a* 返回
                    if(p.charAt(pOfDp-2)=='.'||p.charAt(pOfDp-2)==s.charAt(sOfDp-1)){
                        dp[sOfDp][pOfDp]=dp[sOfDp-1][pOfDp]||dp[sOfDp][pOfDp-2];
                    }else{
                        //形如 a ，ab*，比较 a ，a
                        dp[sOfDp][pOfDp]=dp[sOfDp][pOfDp-2];
                    }
                }
            }
        }
        return dp[slen][plen];
    }
}
