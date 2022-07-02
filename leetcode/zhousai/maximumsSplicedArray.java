package zhousai;
public class maximumsSplicedArray {
    public static int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int[]minus1=minus(nums1,nums2);
        int[]lr1=maxSubArrayIdx(minus1);
        int left1=lr1[0],right1=lr1[1];
        int sum1=0;
        for(int i=0;i<n;i++){
            if(i<left1||i>right1)
                sum1+=nums1[i];
            else
                sum1+=nums2[i];
        }
        int[]minus2=minus(nums2,nums1);
        int[]lr2=maxSubArrayIdx(minus2);
        int left2=lr2[0],right2=lr2[1];
        int sum2=0;
        for(int i=0;i<n;i++){
            if(i<left2||i>right2)
                sum2+=nums2[i];
            else
                sum2+=nums1[i];
        }
        return Math.max(sum1,sum2);
    }
    private static int[]minus(int[]nums1,int[]nums2){
        int[]ret=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ret[i]=nums2[i]-nums1[i];
        }
        return ret;
    }
    private static int[]maxSubArrayIdx(int[]array){
        int left=-1,right=-1,tmp=-1;
        int maxSum=array[0],pre=0;
        for(int i=0;i<array.length;i++){
            if(pre>=0){
                pre=pre+array[i];
            }else{
                pre=array[i];
                tmp=i;
            }
            if(pre>=maxSum){
                maxSum=pre;
                left=tmp;
                right=i;
            }
        }
        System.out.println(left+" "+right);
        return new int[]{left,right};
    }

    public static void main(String[] args) {
        int[]nums1={10,20,50,15,30,10},nums2={40,20,10,100,10,10};
        System.out.println(maximumsSplicedArray(nums1,nums2));
    }
}
