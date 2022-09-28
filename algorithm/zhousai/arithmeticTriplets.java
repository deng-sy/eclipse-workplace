package zhousai;
//2367. ������Ԫ�����Ŀ
//����һ���±�� 0 ��ʼ���ϸ���� ���������� nums ��һ�������� diff �������������ȫ������������Ԫ�� (i, j, k) ����һ�� ������Ԫ�� ��
//
//i < j < k ��
//nums[j] - nums[i] == diff ��
//nums[k] - nums[j] == diff
//���ز�ͬ ������Ԫ�� ����Ŀ��
import java.util.*;

public class arithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            set.add(num);
            if (set.contains(num - diff) && set.contains(num - diff * 2))
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        long time=System.currentTimeMillis();
        System.out.println(new arithmeticTriplets().arithmeticTriplets(nums, diff));
        System.out.println(System.currentTimeMillis()-time);
    }
}
