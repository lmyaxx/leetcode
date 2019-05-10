public class Solution006 {
    public String convert(String s, int numRows) {
        if (numRows==1)
            return s;
        int circle = (numRows-1)*2;
        int len = s.length();
        char [] ans = new char [len];
        int k=0;
        for(int row=0;row < numRows;row++){
            for(int i=row;i<len;i+=circle){
                ans[k++] =s.charAt(i);
                if(row !=0 &&row!=numRows-1 && i+ circle-row*2<len)
                    ans[k++]=s.charAt(i+ circle-row*2);
            }
        }
        return new String(ans);
    }
}
