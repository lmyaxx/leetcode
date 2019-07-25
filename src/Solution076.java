import java.util.*;

public class Solution076 {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        int count = t.length();
        int indexs[] = new int[s.length()];
        for(int i=0;i<count;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
        }
        int left=0,right=0;
        int max_left=-1,min_right=s.length();
        for(int i=0,len=s.length();i<len;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                int num = map.get(ch);
                if(num<0&&count>0)
                    count--;
                indexs[right]=i;
                map.put(ch,num+1);
                while((num=map.get(s.charAt(indexs[left])))>0){
                    map.put(s.charAt(indexs[left]),num-1);
                    left++;
                }
                if(count==0){
                    if(min_right-max_left>indexs[right]-indexs[left]){
                        max_left = indexs[left];
                        min_right = indexs[right];
                    }
                }
                right++;
            }
        }
        if(max_left==-1) return "";
        return s.substring(max_left,min_right+1);
    }
}
