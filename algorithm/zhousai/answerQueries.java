package zhousai;

import java.util.Arrays;

//����һ������Ϊ n ���������� nums ����һ������Ϊ m ���������� queries ��
//
//����һ������Ϊ m ������ answer ������ answer[i] �� nums �� Ԫ��֮��С�ڵ��� queries[i] �� ������ �� ��� ����  ��
//
//������ ����һ������ɾ��ĳЩԪ�أ�Ҳ���Բ�ɾ���������ı�ʣ��Ԫ��˳��õ���һ�����顣
public class answerQueries {
    public int[] answerQueries(int[] nums, int[] queries) {
        int k = queries.length;
        int[] ans = new int[k];
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            int query = queries[i];
            int sum = 0;
            for (int num : nums) {
                sum += num;
                if (sum <= query)
                    ans[i]++;
                else
                    break;
            }
        }
        return ans;
    }
}
