package solution001_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution017 {
    public List<String> letterCombinations(String digits) {
//the input are limited between 2 and 9 ,
//so do not have to deal the cases when the number contains 0 , 1 or any other character
        int len=digits.length();
        if(len==0)
            return new ArrayList<>();
        int size=1;
        String dic[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int length[] = {1,1,3,3,3,3,3,4,3,4};
        String result [] = {""};
        for(int i=0;i<len;i++){
            int pos = digits.charAt(i) - '0';
            int index=0;
            size = size * length[pos];
            String newResult [] = new String[size];
            for(String s : result){
                for(int j=0;j<dic[pos].length();j++){
                    newResult[index++] = s + dic[pos].charAt(j);
                }
            }
            result = newResult;
        }
        return Arrays.asList(result);
    }
}
