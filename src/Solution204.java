public class Solution204 {
    public int countPrimes(int n) {
        n--;
        int res=0;
        while(n>1){
            if(isPrime(n--))
                res++;
        }
        return res;
    }

    private boolean isPrime(int n){
        int m=2;
        while(m<=n/m){
            if(n%m==0) return false;
            m++;
        }
        return true;
    }
    public int countPrimes1(int n) {
        boolean [] notPrimer = new boolean[n];
        int res =0;
        for(int i=2;i<n;i++){
            if(notPrimer[i]==false) {
                res++;
                for (int j = 2; j * i < n; j++)
                    notPrimer[i * j] = true;
            }
        }
        return res;
    }
}
