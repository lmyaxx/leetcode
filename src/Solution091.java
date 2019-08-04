public class Solution091 {
    public int numDecodings(String s) {
        return helper(s,0);
    }
    private int helper(String s,int pos){
        if(pos==s.length()-1&&s.charAt(pos)=='0') return 0;
        if(pos>=s.length()-1) return 1;
        if(s.charAt(pos)=='0') return 0;
        if(s.charAt(pos)=='1') return helper(s,pos+1)+helper(s,pos+2);
        if(s.charAt(pos)=='2'&&s.charAt(pos+1)>='0'&&s.charAt(pos+1)<='6'){
            return helper(s,pos+1)+helper(s,pos+2);
        }
        return helper(s,pos+1);
    }
//  2222
//     10
//     2222
//
    public int numDecodings1(String s) {
// index means length
        int judge[] = new int[s.length()+1];
        if(s.charAt(0)=='0') return 0;
        judge[0] = 1;judge[1] = 1;
        for(int i=1,len=s.length();i<len;i++){
           if(s.charAt(i-1)=='1'){
               if(s.charAt(i)=='0'){
                   judge[i+1]=judge[i-1];
               }else{
                   judge[i+1]=judge[i-1]+judge[i];
               }
               continue;
           }
           if(s.charAt(i-1)=='2'){
               if(s.charAt(i)=='0'){
                   judge[i+1]=judge[i-1];
               }else if(s.charAt(i)>='1'&&s.charAt(i)<='6'){
                   judge[i+1]=judge[i]+judge[i-1];
               }
               else {
                   judge[i+1]=judge[i];
               }
               continue;
           }
           if(s.charAt(i)=='0') return 0;
           judge[i+1]=judge[i];
        }
        return judge[s.length()];
    }
}
