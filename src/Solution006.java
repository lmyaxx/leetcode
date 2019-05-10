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
                /*
                为了解释i+ circle-row*2
                对于每一轮循环，如下例，对每一轮循环大小为6的数字
                编号0，1，2，3，4，5，
                分别P,A,Y,P,A,L
                可见1与5号在同行，2与4号在同行，其和都为6，所以可以得到两者间的距离为
                （circle-row）-row
                P     I    N
                A   L S  I G
                Y A   H R
                P     I
                 */
            }
        }
        return new String(ans);
    }
}
