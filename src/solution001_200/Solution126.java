package solution001_200;

import javafx.util.Pair;

import java.util.*;

public class Solution126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if(!wordList.contains(endWord)) return res;
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        begin.add(beginWord);
        end.add(endWord);
        bfs(begin,end,dict,map,false);
        List<String> out = new ArrayList<>();
        out.add(beginWord);
        dfs(beginWord,endWord,res,out,map);
        return res;
    }

    private void bfs(Set<String> begin, Set<String> end, Set<String> dict, Map<String, List<String>> map, boolean reverse){
        if(begin.isEmpty()) return;
        if(begin.size()>end.size()){
            bfs(end,begin,dict,map,!reverse);
            return;
        }
        dict.removeAll(begin);
        boolean finish = false;
        Set<String> newSet = new HashSet<>();
        for(String now:begin){
            char [] chs = now.toCharArray();
            for(int i=0;i<chs.length;i++){
                for(char ch = 'a';ch<='z';ch++){
                    if(ch==chs[i])
                        continue;
                    char old = chs[i];
                    chs[i] = ch;
                    String next = String.valueOf(chs);
                    if(dict.contains(next)){
                        if(end.contains(next)){
                            finish=true;
                        }else {
                            newSet.add(next);
                        }
                        String key = reverse ? next:now;
                        String val = reverse ? now:next;
                        if(!map.containsKey(key)){
                            map.put(key, new ArrayList<>());
                        }
                        map.get(key).add(val);
                    }
                    chs[i] = old;
                }
            }
        }
        begin = newSet;
        if(!finish){
            bfs(begin,end,dict,map,reverse);
        }
    }


    private void dfs(String begin, String end, List<List<String>> res, List<String> list, Map<String, List<String>> map){
        if(begin.equals(end)) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(!map.containsKey(begin))
            return;
        for(String str:map.get(begin)){
            list.add(str);
            dfs(str,end,res,list,map);
            list.remove(list.size()-1);
        }

    }
}
