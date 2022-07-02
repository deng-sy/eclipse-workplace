package kuaishou;

public class search {
    public static int search(int[] nums, int target) {
        int n=nums.length;
        int left=0,right=n-1;
        while(left<=right){
            int mid=(right+left)/2;
            if(target==nums[mid]){
                int low=mid-1,high=mid+1;
                while(low>=0&&nums[low]==target){
                    low--;
                }
                while(high<n&&nums[high]==target){
                    high++;
                }
                return high-low-1;
            }else if(target<nums[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[]nums={5,7,7,8,8,10};
        System.out.println(search(nums,6));
    }
}
