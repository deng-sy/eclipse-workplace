package zhousai;

import java.util.Arrays;

//�����ڲμ�һ���������������� �� ���� initialEnergy �� initialExperience �ֱ��ʾ��ĳ�ʼ�����ͳ�ʼ���顣
//
//����������±�� 0 ��ʼ���������� energy �� experience�����Ⱦ�Ϊ n ��
//
//�㽫�� ���� ���� n �����֡��� i �����ֵľ����;���ֱ��� energy[i] �� experience[i] ��ʾ��������϶���ʱ����Ҫ�ھ���;����϶� �ϸ� �������ֲ��ܻ������ǣ�Ȼ���ڿ��ܵ�����¼���������һ�����֡�
//
//���ܵ� i �����ֻ�ʹ��ľ��� ���� experience[i]�����Ὣ��ľ��� ����  energy[i] ��
//
//�ڿ�ʼ����ǰ�������ѵ������Сʱ��ÿѵ��һ��Сʱ�������ѡ�����Ӿ������� 1 ���� ���������� 1 ��
//
//���ػ���ȫ�� n ��������Ҫѵ���� ���� Сʱ��Ŀ��
public class minNumberOfHours {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        int sum_energy = 1;
        for (int e : energy) {
            sum_energy += e;
        }
        ans += Math.max(0, sum_energy - initialEnergy);
        int max_experience = 0;
        int max_idx = 0;
        for (int i = 0; i < experience.length; i++) {
            if (max_experience < experience[i]) {
                max_experience = experience[i];
                max_idx = i;
            }
        }
        max_experience++;
        for (int i = max_idx - 1; i >= 0; i--) {
            max_experience = Math.max(experience[i]+1, max_experience - experience[i]);
            if (max_experience == 0)
                break;
        }
        ans += Math.max(0, max_experience - initialExperience);
        return ans;
    }
}
