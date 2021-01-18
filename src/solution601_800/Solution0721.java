package solution601_800;

import java.util.*;

/**
 * @author: chad li
 * @date: 2021/1/18
 * @discription:
 */
public class Solution0721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> accountToName = new HashMap<>();
        UnionFind unionFind = new UnionFind();
        for(List<String> accountsOfOne : accounts){
            String name = accountsOfOne.get(0);
            for(int i = 1; i< accountsOfOne.size(); i++){
                unionFind.union(accountsOfOne.get(1),accountsOfOne.get(i));
                accountToName.put(accountsOfOne.get(i),name);
            }
        }
        Map<String,TreeSet<String>> cache = new HashMap<>();
        for(List<String> accountOfOne: accounts){
            for (int i = 1; i < accountOfOne.size(); i++) {
                String account = accountOfOne.get(i);
                String root = unionFind.find(account);
                cache.computeIfAbsent(root, key->new TreeSet<>()).add(account);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, TreeSet<String>> one : cache.entrySet()){
            LinkedList<String> item = new LinkedList(one.getValue());
            item.addFirst(accountToName.get(one.getKey()));
            ans.add(item);
        }
        return ans;
    }

    class UnionFind {
        HashMap<String, String> pre;
        public UnionFind(){
            pre = new HashMap<>();
        }
        public void union(String account1, String account2 ){
            String root1 = find(account1);
            String root2 = find(account2);
            if(root1.equals(root2)){
                return;
            }
            pre.put(root1,root2);
        }
        public String find(String account){
            if(!pre.containsKey(account)){
                pre.put(account,account);
            }
            if(!pre.get(account).equals(account)){
                pre.put(account,find(pre.get(account)));
            }
            return pre.get(account);
        }
    }
}
