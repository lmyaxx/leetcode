package solution1401_1600;

public class Solution1491 {
    public double average(int[] salary) {
        double min = Integer.MAX_VALUE, max =Integer.MIN_VALUE;
        double ans = 0;
        for(int s: salary){
            min = Math.min(min,s);
            max = Math.max(max,s);
            ans += s;
        }
        return (ans-min-max) / (salary.length - 2);
    }
}
