public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;
        for(int i=0;i<gas.length;i++){
            gas[i]-=cost[i];
            sum+=gas[i];
        }
        if(sum>=0){
            int j=0,i=0;
            while(j<gas.length){
                if(gas[j]>=0)
                    i=j;
                sum =gas[j];
                while (++j<gas.length&&sum>=0){
                    sum+=gas[j];
                }
            }
            return i;
        }
        return -1;
    }
}
