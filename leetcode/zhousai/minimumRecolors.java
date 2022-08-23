package zhousai;
//����һ������Ϊ n �±�� 0 ��ʼ���ַ��� blocks ��blocks[i] Ҫô�� 'W' Ҫô�� 'B' ����ʾ�� i �����ɫ���ַ� 'W' �� 'B' �ֱ��ʾ��ɫ�ͺ�ɫ��

//����һ������ k ����ʾ��Ҫ ���� ��ɫ�����Ŀ��
//ÿһ�β����У������ѡ��һ����ɫ�齫�� Ϳ�� ��ɫ�顣
//���㷵�����ٳ��� һ�� ���� k ����ɫ��� ���� ����������
public class minimumRecolors {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = blocks.charAt(i) == 'W' ? 0 : 1;
        }
        int left = 0;
        int ans = n;
        int cur = 0;
        for (int right = 0; right < k; right++) {
            cur += 1 - nums[right];
        }
        ans = Math.min(ans, cur);
        for (int right = k; right < n; right++) {
            if (nums[right] == 1)
                cur -= 1 - nums[left];
            else
                cur += nums[left];
            left++;
            ans = Math.min(ans, cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        String blocks = "BWWWBB";
        int k = 6;
        System.out.println(new minimumRecolors().minimumRecolors(blocks, k));
    }
}
