import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author: chad li
 * @date: 2021/1/12
 * @discription:
 */
public class Solution1203 {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        HashMap<Integer,HashSet<Integer>> groupContent = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> itemNext = new HashMap<>();
        for(int i = 0; i<group.length; i++){
            if(group[i] == -1){
                group[i] = m;
                m++;
            }
            groupContent.computeIfAbsent(group[i],key->new HashSet<>()).add(i);
        }
        int[] groupInDegree = new int[m];
        int[] itemInDegree = new int[n];
        for(int i = 0; i< beforeItems.size(); i++){
            List<Integer> before = beforeItems.get(i);
            itemInDegree[i] = before.size();
            HashSet<Integer> groupItems = groupContent.get(group[i]);
            for(Integer pre: before){
                itemNext.computeIfAbsent(pre,key-> new HashSet<>()).add(i);
                if(!groupItems.contains(pre)){
                    groupInDegree[group[i]] ++;
                }
            }
        }
        System.out.println(Arrays.toString(groupInDegree));
        TreeMap<Integer, HashSet<Integer>> inDegreeToGroup = new TreeMap<>();
        for(int i = 0; i < groupInDegree.length; i++){
            inDegreeToGroup.computeIfAbsent(groupInDegree[i],key->new HashSet<>()).add(i);
        }
        int[] ans = new int[n];
        int idx = 0;
        System.out.println(groupContent.toString());
        System.out.println(inDegreeToGroup.toString());
        while (inDegreeToGroup.size()>0 && inDegreeToGroup.containsKey(0)&&!inDegreeToGroup.get(0).isEmpty()){
            // 待移除的组别
            int toSolve = inDegreeToGroup.get(0).iterator().next();
            HashSet<Integer> groupMembers = groupContent.get(toSolve);
            if(groupMembers == null || groupMembers.isEmpty()){
                inDegreeToGroup.get(0).remove(toSolve);
                continue;
            }
            TreeMap<Integer, HashSet<Integer>> inDegreeToItem = new TreeMap<>();
            for(int member: groupMembers){
                inDegreeToItem.computeIfAbsent(itemInDegree[member],key->new HashSet<>()).add(member);
            }
            while(!inDegreeToItem.isEmpty()&&inDegreeToItem.containsKey(0)&&!inDegreeToItem.get(0).isEmpty()){
                //待移除的组别成员
                int toRemove = inDegreeToItem.get(0).iterator().next();
                ans[idx++] = toRemove;
                if(itemNext.containsKey(toRemove)){
                    HashSet<Integer> nextItems = itemNext.get(toRemove);
                    for(Integer next: nextItems){
                        if(groupMembers.contains(next)){
                            //组内:成员入度组别关系变更
                            inDegreeToItem.get(itemInDegree[next]).remove(next);
                            inDegreeToItem.computeIfAbsent(itemInDegree[next]-1,key->new HashSet<>()).add(next);
                        }else{
                            //组外:入度组别关系变更
                            inDegreeToGroup.get(groupInDegree[group[next]]).remove(group[next]);
                            inDegreeToGroup.computeIfAbsent(groupInDegree[group[next]] - 1,
                                    key->new HashSet<>()).add(group[next]);
                            groupInDegree[group[next]]--;

                        }
                        //全局入度变更
                        itemInDegree[next]--;
                    }
                }
                inDegreeToItem.get(0).remove(toRemove);
                groupMembers.remove(toRemove);
            }
            //入度为0的组别未能清除
            if(!groupMembers.isEmpty()){
                return new int[]{};
            }
            inDegreeToGroup.get(0).remove(toSolve);
            System.out.println(inDegreeToGroup.toString());
            System.out.println();

        }
        if(idx != ans.length){
            return new int[]{};
        }
        return ans;
    }
}
