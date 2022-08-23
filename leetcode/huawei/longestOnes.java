package huawei;

//����һ������������ nums ��һ������ k��������Է�ת��� k �� 0 ���򷵻����������� 1 �������� ��
public class longestOnes {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            rsum += 1 - nums[right];
            while (lsum < rsum - k) {
                lsum += 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]nums={0,0,1,1,0,1,1,0};
        int k=2;
        System.out.println(new longestOnes().longestOnes(nums,k));
    }
}
