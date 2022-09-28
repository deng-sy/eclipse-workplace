package zhousai;

//2407. ����������� II
//����һ���������� nums ��һ������ k ��
//
//�ҵ� nums ����������Ҫ���������У�
//
//������ �ϸ����
//������������Ԫ�صĲ�ֵ������ k ��
//���㷵����������Ҫ��� ������� �ĳ��ȡ�
//
//������ �Ǵ�һ��������ɾ������Ԫ�غ�ʣ��Ԫ�ز��ı�˳��õ������顣
public class lengthOfLIS {
    int[] max;//max[i]��ʾ�߶�����i���ڵ�����ʾ�������ڵ������������ĳ��ȣ����ս��Ϊmax[1]����[1,max(nums)]�ڵĽ��

    public int lengthOfLIS(int[] nums, int k) {
        var u = 0;
        for (var x : nums) u = Math.max(u, x);
        max = new int[u * 4];
        for (var x : nums) {
            if (x == 1) modify(1, 1, u, 1, 1);//��1��β�ģ�����������鳤��һ��Ϊ1
            else {
                var res = 1 + query(1, 1, u, Math.max(x - k, 1), x - 1);//��x��β�ģ�����������鳤��Ϊ[x-k,x-1]�ڵĽڵ��Ӧ������������鳤�ȵ����ֵ+1
                modify(1, 1, u, x, res);
            }
        }
        return max[1];
    }

    private void modify(int o, int l, int r, int idx, int val) {
        if (l == r) {
            max[o] = val;
            return;
        }
        var m = (l + r) / 2;
        if (idx <= m) modify(o * 2, l, m, idx, val);
        else modify(o * 2 + 1, m + 1, r, idx, val);
        max[o] = Math.max(max[o * 2], max[o * 2 + 1]);
    }

    // �������� [L,R] �ڵ����ֵ
    private int query(int o, int l, int r, int L, int R) { // L �� R �������ݹ�����о����䣬�����д����������
        if (L <= l && r <= R) return max[o];
        var res = 0;
        var m = (l + r) / 2;
        if (L <= m) res = query(o * 2, l, m, L, R);
        if (R > m) res = Math.max(res, query(o * 2 + 1, m + 1, r, L, R));
        return res;
    }


}
