public class Solution004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(m<n)
            return findMedianSortedArrays(nums2,nums1);
        if(n==0) return (nums2[m/2]+nums2[(m-1)/2])/2.0;

//  此处利用了马拉车算法
//  nums1    n    [# 1 # 1 / 1 # 1 #]
//  nums2    m    [# 1 # 2 # (3/3) # 4 # 5 #]
//  if mid1 = 4, then  mid2 = (4 + 5 - 4) = 5,根据这个进行划分
//        对以任意数量n的有序数列nums，其中位数为 (L + R) / 2 = (nums[(n-1)/2] + nums[n/2]) / 2
//        对于两个数组nums1 、nums2，长度分别为n，m，分插“#”扩充为 2 n + 1  , 2m + 1个
//        对于nums1中的位置k（下标从0开始），则其左侧有k个
//        同样对于nums2中的位置h（下表从0开始），则其左侧有h个数字。
//        若h，k将两个数组划分成均等两半，则k+h = m + n，（由于总长2(m+n) + 2,h和m占2个），m、n已知，故h = m + n - k.
//        然后根据h和 k的位置找出各自的左右4个位置对应的数字。
//        可以直接利用(k-1)/2 ,k/ 2来确定。 利用带#的位置必然是奇数，以7为例，3.5 = 3， 3.0 = 3
        int left = 0,right = 2 * n;
        while(left <= right){
            int mid1 = (left+right)/ 2;
            int mid2 = n + m - mid1;
            double L1 = mid1==0 ? Double.MIN_VALUE :  nums1[(mid1-1)/2];
            double R1 = mid1==n*2 ? Double.MAX_VALUE : nums1[mid1/2];
            double L2 = mid2 == 0 ? Double.MIN_VALUE : nums2[(mid2-1)/2];
            double R2 = mid2 == m*2 ? Double.MAX_VALUE : nums2[mid2/2];
            if(R1<L2){
                left = mid1 + 1;
            }else if(R2<L1){
                right = mid1 -1;
            }else{
                return (Math.max(L1,L2) + Math.min(R1,R2))/2.0;
            }
        }
        return -1;
    }
}

