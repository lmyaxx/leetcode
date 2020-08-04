package solution001_200;

import java.util.ArrayList;
import java.util.List;

public class Solution022 {
    public List<String> generateParenthesis(int n) {
        List<String> li = new ArrayList<>();
        generateString(li,"",n,n);
        return li;
    }
    //left：the number of ‘(’ unused
    //right：the number of ‘)’ unused
    public void generateString(List<String> li,String s,int left,int right){
        if(left==0){
            while(right-->0){
                s +=')';
            }
            li.add(s);
        }
        else {
            if(right==left){
                generateString(li,s+'(',left-1,right);
            }else if(right>left) {
                generateString(li, s + '(', left - 1, right);
                generateString(li, s + ')', left, right - 1);
            }
        }
    }
}
