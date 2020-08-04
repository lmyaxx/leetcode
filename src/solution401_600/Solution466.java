package solution401_600;

import java.util.*;

/**
 * @Author : Chad li
 * @Date : 2020/4/24 20:37
 * @Version 1.0
 */
public class Solution466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len2 = s2.length(), cur1 = 0, cur2 = 0;
        Set<Character> set1 = new HashSet<>();
        s1 = removeOthers(s1, s2);
        int len1 = s1.length();
        for(int i=0;i<len1;i++){
            set1.add(s1.charAt(i));
        }
        for(int i=0;i<len2;i++){
            if(!set1.contains(s2.charAt(i))){
                return 0;
            }
        }
        int total1 = n1*len1;
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        int circle = 0;
        while(cur1<total1){
            if(ss1[cur1%len1]==ss2[cur2%len2]){
                cur2++;
            }
            cur1++;
            if(cur1<total1&&cur1%len1==0&&cur2%len2==0){
                circle = n1/(cur1/len1);
                cur1 = circle*cur1;
                cur2 = circle*cur2;
            }
        }
        return cur2 / len2 / n2;
    }
    private String removeOthers(String s1, String s2){
        Set<Character> set2 = new HashSet<>();
        for(int i=0;i<s2.length();i++){
            set2.add(s2.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ;i<s1.length();i++){
            if(set2.contains(s1.charAt(i))){
                sb.append(s1.charAt(i));
            }
        }
        return sb.toString();
    }


    public int getMaxRepetitions1(String s1, int n1, String s2, int n2) {
        if (!verifyInput(s1, s2)) {
            return 0;
        }

        int totalOccurrence = 0;
        String remaining = "", str = s1;
        boolean loopFound = false;
        Map<String, Integer> cycleIndex = new HashMap<String, Integer>();
        ArrayList<Integer> occurenceCountAtEachCycle = new ArrayList<Integer>();

        for (int i = 0; i <= n1; i++) {
            StringBuilder sb = new StringBuilder();
            totalOccurrence += getRemaining(str, s2, sb);
            remaining = sb.toString();

            if (cycleIndex.containsKey(remaining)) {
                loopFound = true;
                break;
            }

            cycleIndex.put(remaining, i);

            occurenceCountAtEachCycle.add(totalOccurrence);

            str = remaining + s1; // append s1 to make a new string
        }

        if (!loopFound) {
            return totalOccurrence / n2; // if there is no loop
        }

        int indexBeforeLoop = cycleIndex.get(remaining);

        int occurrenceCountInLoopCycle = totalOccurrence - occurenceCountAtEachCycle.get(indexBeforeLoop);

        // represents the number of cycles required to complete a loop
        int loopCycleLength = occurenceCountAtEachCycle.size() - indexBeforeLoop;

        // resetting the total occurrence to cycle before loop happened
        totalOccurrence = occurenceCountAtEachCycle.get(indexBeforeLoop);

        // removing cycles from n1 before loop started. Adding 1 as n1 is 1 based and other index are 0 based
        n1 -= (indexBeforeLoop + 1);

        // total occurrence is number of occurrence before loop + number of occurrence in loops for the rest of n1
        totalOccurrence += occurrenceCountInLoopCycle * (n1 / loopCycleLength);

        // if loop cycle terminated prematurely then the remaining cycles should be accounted
        n1 %= loopCycleLength;

        if(n1 != 0){
            // occurenceCountAtEachCycle.get(indexBeforeLoop) is required because we just want to add the left over cycles of incomplete loop.
            totalOccurrence += occurenceCountAtEachCycle.get(indexBeforeLoop + n1) - occurenceCountAtEachCycle.get(indexBeforeLoop);
        }

        return totalOccurrence / n2;
    }

    // check if s1 contains all s2 characters
    private boolean verifyInput(String s1, String s2) {
        boolean[] arr = new boolean[26];

        for (char ch : s1.toCharArray()) {
            arr[ch - 'a'] = true;
        }

        for (char ch : s2.toCharArray()) {
            if (!arr[ch - 'a']){
                return false;
            }
        }

        return true;
    }

    // get remain string after s1 obtains s2, return the matching count
    private int getRemaining(String s1, String s2, StringBuilder remaining) {
        int count = 0, lastMatchIdx = -1, s2Idx = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(s2Idx)) {
                if (++s2Idx == s2.length()) {
                    s2Idx = 0;
                    count++;
                    lastMatchIdx = i;
                }
            }
        }
        remaining.append(s1.substring(lastMatchIdx + 1));
        return count;
    }
}
