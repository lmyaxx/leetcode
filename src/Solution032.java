public class Solution032 {
    public int longestValidParentheses(String s)
    {
        int open=0;
        int close=0;
        int longest=0;
        //存在左侧(((()))的情况
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                open++;
            }
            else
            {
                close++;
            }
            if(open==close)
            {
                longest=Math.max(longest,2*close);
            }
            else if(close>open)
            {
                open=0;
                close=0;
            }

        }
        //存在(((()))))的情况
        open=0;
        close=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='(')
            {
                open++;
            }
            else
            {
                close++;
            }
            if(open==close)
            {
                longest=Math.max(longest,2*close);
            }
            else if(close<open)
            {
                open=0;
                close=0;
            }

        }
        return longest;
    }
}
