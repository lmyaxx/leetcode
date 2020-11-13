package internet;

import java.util.*;

public class Factor {
    //N = 12；
    //Ans = {12},{6,2},{3,4},{3,2,2}
    public List<List<Integer>> factorsOf(int N){
        List<Integer> factors = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        while(N>1){
            for(int i = 2; i <= N; i++){
                if(N % i == 0){
                    N /= i;
                    factors.add(i);
                    break;
                }
            }
        }
        List<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        one.add(factors.get(0));
        ans.add(one);
        for(int i = 1; i < factors.size(); i ++){
            List<ArrayList<Integer>> cache = new ArrayList<>();
            int take = factors.get(i);
            HashSet<String> set = new HashSet<>();
            for(ArrayList<Integer> list : ans){
                for(int k = 0; k < list.size(); k ++){
                    int num = list.get(k);
                    ArrayList<Integer> newOne = (ArrayList<Integer>) list.clone();
                    newOne.set(k, num * take);
                    Collections.sort(newOne);
                    if(set.add(newOne.toString())){
                        cache.add(newOne);
                    }
                }
                list.add(take);
                Collections.sort(list);
                if(set.add(list.toString())){
                    cache.add(list);
                }
            }
            ans = cache;
        }
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> list: ans){
            result.add(list);
        }
        return result;
    }



    public static void main(String[] args) {
        Factor factor = new Factor();
        List<List<Integer>> ans = factor.factorsOf(1024 * 1024);
        System.out.println(ans.size());
        System.out.println(ans.toString());
    }
}
