public class Solution038 {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        else{
            String s = countAndSay(n-1);
            String res = "";
            int count=0;
            char a = s.charAt(0);
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==a){
                    count++;
                }else{
                    res+=Integer.toString(count) + a;
                    a=s.charAt(i);
                    count=0;
                    i--;
                }
            }
            res+=Integer.toString(count) + a;
            return res;
        }
    }

    public String countAndSay1(int n) {
        StringBuilder s = new StringBuilder();
        s.append(1);
        for(int i=1;i<n;i++){
            StringBuilder buff= new StringBuilder();
            int count=0;
            char a = s.charAt(0);
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)==a){
                    count++;
                }else{
                    buff.append(count).append(a);
                    a=s.charAt(j);
                    count=0;
                    j--;
                }
            }
            buff.append(count).append(a);
            s = buff;
        }
        return s.toString();
    }
}
