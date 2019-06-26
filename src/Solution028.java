public class Solution028 {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        int next[] = getNext(needle);
        int len= needle.length();
        int k = next[0];
        for(int i = 0,length = haystack.length(); i < length; i++){
            while(k > -1 && needle.charAt(k + 1) != haystack.charAt(i)){
                k = next[k];
            }
            if(needle.charAt(k + 1) == haystack.charAt(i)){
                k = k + 1;//成功匹配一个节点
            }
            if(k == len-1){//上面一直说k等于已经匹配的长度-1
                return i - len + 1;
            }
        }
        return -1;
    }
    public static int[] getNext(String target){
        //next is to store the offset info
        int[] next = new int[target.length()];
        next[0] = -1;
        int k = -1;
        /*
        pattern      pre=suf       next
        a            ""         -1
        ab           ""         -1
        aba          "a"         0
        abab         "ab"        1
        ababa        "aba"       2
        ababac        ""         -1
        ababaca       "a"        0
         */
        // next = [-1,-1,0,1,2,-1,0]
        /*    .                    .                    .                 .
        i=1  ababaca       i=2   ababaca       i=3   ababaca      i=4 ababaca
        k=-1  ababaca      k=0     ababaca     k=1     ababaca    k=2   ababaca
                   .                 .                   .                   .
        i=5   ababaca      i=5  ababaca        i=5  ababaca
        k=2     ababaca    k=0      ababaca    k=-1      ababaca
                           next[2]             next[0]
                           
        为什么下一个next的index是next[k]的值？
        对于pattern[:k+1],必定pattern[:next[k]+1] = pattern[-(next[k]+1):]
        若pattern[-(next[k]+1):]的下一个字符不匹配，
        则尝试匹配pattern[:next[k]+1]的下一个字符。
        要使pattern[:k+1] = pattern[:next[k]+1] ，所以k=next[k]
        例如i=5，k=2时，pattern[:2+1]=aba,
        则pattern[:next[2]+2] = patter[:1] = pattern[-(next[k]+1):] = pattern[-1:] = a
        aba?不成功，应对a?进行判断
         */
        for(int i = 1; i < target.length(); i++){
            while(k > -1 && target.charAt(k + 1) !=  target.charAt(i)){
                //能运行到这里，就说明不是我们最希望的状况，而这个循环就是当状况不好时，退而求其次，“缩短”能偷得懒。
                //k > -1有两个作用，1是是防止访问越界2是k如果<=-1表示不存在最长前/后缀，就没有必要找了
                k = next[k];
            }
            //跳出循环有两种情况，一种是找到了一个缩短后能用的，一个就是k等于-1了
            if (target.charAt(k + 1) ==  target.charAt(i)){
                k = k + 1;
            }
            next[i] = k;
        }
        return next;
    }
}
