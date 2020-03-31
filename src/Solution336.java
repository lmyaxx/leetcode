import java.util.*;

/**
 * @Author : Chad li
 * @Date : 2020/3/31 17:46
 * @Version 1.0
 */
public class Solution336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new LinkedList<>();
        if(words == null || words.length == 0){
            return ans;
        }
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
        }
        if(map.containsKey("")){
            int blankId = map.get("");
            for(int i=0;i<words.length;i++){
                if(i!=blankId&&isPalindrome(words[i])){
                    ans.add(Arrays.asList(blankId,i));
                    ans.add(Arrays.asList(i,blankId));
                }
            }
        }
        for(int i=0;i<words.length;i++){
            String rev = reverse(words[i]);
            if(map.containsKey(rev)){
                int r = map.get(rev);
                if(r!=i){
                    ans.add(Arrays.asList(i,r));
                }
            }
        }
        //find the pair s1, s2 that
        //case1 : s1[0:cut] is palindrome and s1[cut+1:] = reverse(s2) => (s2, s1)
        //case2 : s1[cut+1:] is palindrome and s1[0:cut] = reverse(s2) => (s1, s2)
        for(int i=0;i<words.length;i++){
            String word = words[i];
            for(int cut=1;cut<word.length();cut++){
                String front = word.substring(0,cut);
                String rear = word.substring(cut);
                if(isPalindrome(front)){
                    Integer l = map.get(reverse(rear));
                    if(l!=null){
                        ans.add(Arrays.asList(l,i));
                    }
                }
                if(isPalindrome(rear)){
                    Integer r = map.get(reverse(front));
                    if(r!=null){
                        ans.add(Arrays.asList(i,r));
                    }
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String word){
        int i=0,j=word.length()-1;
        while(i<j){
            if(word.charAt(i++)!=word.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    private String reverse(String word){
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }
}
