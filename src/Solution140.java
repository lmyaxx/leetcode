import java.util.*;

public class Solution140 {

    public List<String> wordBreak1(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<Integer> steps = new TreeSet<>();
        for(String word:wordDict){
            steps.add(word.length());
        }
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer,List<String>> memo = new HashMap<>();
        for(int i=0,len=s.length();i<len;i++){
            List<String> level = new LinkedList<>();
            String cur = s.substring(0,i+1);
            if(set.contains(cur)){
                level.add(cur);
            }
            for(Integer step:steps){
                if(i+1-step<1) break;
                if(memo.get(i-step).isEmpty()) continue;
                cur = s.substring(i+1-step,i+1);
                if(!set.contains(cur)) continue;
                for(String sss: memo.get(i-step)){
                    level.add(sss+" "+cur);
                }

            }
            memo.put(i,level);
        }
        return memo.get(s.length()-1);
    }
}
