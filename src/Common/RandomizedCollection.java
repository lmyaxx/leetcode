package Common;

import java.util.*;

/**
 * @Author : Chad li
 * @Date : 2020/4/4 18:24
 * @Version 1.0
 */
public class RandomizedCollection {

    private int size;
    private int limit;
    private int[]nums;
    private Map<Integer, Set<Integer>> map;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        limit = 15;
        nums = new int[limit];
        size = 0;
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isUnique = true;
        size ++;
        if(size>limit){
            limit = limit + (limit>>1);
            int[] temp = new int[limit];
            System.arraycopy(nums,0,temp,0,nums.length);
            nums = temp;
        }
        nums[size-1] = val;
        Set<Integer> list = map.get(val);
        if(list!=null){
            list.add(size-1);
            isUnique = false;
        }else{
            HashSet<Integer> set = new HashSet<>();
            set.add(size-1);
            map.put(val,set);
        }
        return isUnique;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        for(Map.Entry<Integer,Set<Integer>> entry:map.entrySet()){
            System.out.println(entry.getKey()+entry.getValue().toString());
        }
        Set<Integer> indexes = map.get(val);
        if(indexes==null){
            return false;
        }
        size--;
        Set<Integer> last = map.get(nums[size]);
        if(last == indexes){
            indexes.remove(size);
        }else{
            int index = indexes.iterator().next();
            // move last one to the position of deleted one, and update the index
            last.remove(size);
            last.add(index);
            nums[index] = nums[size];
            //update the index of removed one
            indexes.remove(index);
        }
        if(indexes.isEmpty()){
            map.remove(val);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int index = random.nextInt(size);
        return nums[index];
    }
}
