import java.util.ArrayList;
import java.util.List;

public class Solution093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        for(int i=1,len=s.length();i<=3&&i<len;i++){
            if(isValid(s,0,i)){
                for(int j=i+1;j<=i+3&&j<len;j++){
                    if(isValid(s,i,j)){
                        for(int k=j+1;k<=j+3&&k<len;k++){
                            if(isValid(s,j,k)&&isValid(s,k,len)){
                                result.add(s.substring(0,i)+"."+s.substring(i,j)+"."+s.substring(j,k)+
                                        "."+s.substring(k,len));
                            }
                        }
                    }
                }
            }
        }
        return  result;
    }

    private boolean isValid(String s,int left,int right){
        if(right-left>3) return false;
        int num = Integer.parseInt(s.substring(left,right));
        switch (right-left){
            case 1:return true;
            case 2:return num>=10;
            case 3:return num>=100&&num<=255;
        }
        return false;
    }
}
