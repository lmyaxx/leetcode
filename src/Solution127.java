import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution127 {
    int steps = 1;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 1;
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        if(helper(begin,end,dict))
            return steps;
        else return 0;
    }

    private boolean helper(Set<String> begin,Set<String> end,Set<String> dict){
        if(begin.isEmpty()) return false;
        if(begin.size()>end.size()) {
            return helper(end,begin,dict);
        }
        steps++;
        dict.removeAll(begin);
        Set<String> newSet = new HashSet<>();
        for(String str:begin){
            char chs[] = str.toCharArray();
            for(int i=0;i<chs.length;i++){
                for(char ch='a';ch<='z';ch++){
                    if(ch==chs[i])
                        continue;
                    char old = chs[i];
                    chs[i] = ch;
                    String temp = String.valueOf(chs);
                    if(dict.contains(temp)){
                        if(end.contains(temp)){
                            return true;
                        }
                        newSet.add(temp);
                    }
                    chs[i] =old;
                }
            }
        }
        begin = newSet;
        return helper(begin,end,dict);
    }
}
