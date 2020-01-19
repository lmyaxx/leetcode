package Common;

import java.util.*;

/**
 * @Author : Chad li
 * @Date : 2020/1/19 20:48
 * @Version 1.0
 */
public class RandomizedSet {
    Random random;
    private List<Integer> list;
    private Map<Integer,Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        random = new Random();
        list = new ArrayList();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int pos = map.get(val);
        Collections.swap(list,pos,list.size()-1);
        map.put(list.get(pos),pos);
        map.remove(list.get(list.size()-1));
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
