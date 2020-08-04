package solution001_200;

public class Solution088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
        int index1 = 0,index2=0;
        for(;index1<m&&index2<n;index1++){
            if(nums2[index2]<nums1[index1]){
                for(int k=m++;k>index1;k--){
                    nums1[k]=nums1[k-1];
                }
                nums1[index1]=nums2[index2++];
            }
        }
        while(index2<n){
            nums1[index1++]=nums2[index2++];
        }
    }
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
        int right=n+m-1;
        m--;n--;
        while(right>m){
            if(m<0||(n>=0&&nums2[n]>=nums1[m]))
                nums1[right--]=nums2[n--];
            else
                nums1[right--]=nums1[m--];
        }
    }

}
