package solution401_600;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Supplier;

/**
 * @Author : Chad li
 * @Date : 2020/4/29 20:17
 * @Version 1.0
 */
public class Solution480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a,b) -> nums[a] !=nums[b] ? Integer.compare(nums[a],nums[b]) : a-b;
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);
        Supplier<Double> median = (k%2==0) ?
                ()-> ((double)nums[left.first()] + nums[right.first()])/2:
                ()-> (double)nums[right.first()];
        Runnable balance = () -> {
            while (left.size()>right.size()){
                right.add(left.pollFirst());
            }
        };
        double[] res = new double[nums.length - k +1];
        for(int i=0;i<k;i++){
            left.add(i);
        }
        balance.run();
        res[0] = median.get();
        for(int i=k;i<nums.length;i++){
            if(!left.remove(i-k)){
                right.remove(i-k);
            }
            right.add(i);
            left.add(right.pollFirst());
            balance.run();
            res[i-k+1] = median.get();
        }
        return res;
    }
}
