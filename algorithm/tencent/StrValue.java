package tencent;
//����һ��ֻ���� 0 �� 1 �� 01 �� s ���±�� 1 ��ʼ����� i λ�ļ�ֵΪ vali �����ֵ�������£�
//1. i=1ʱ:val1 = 1
//2. i>1ʱ��
//2.1 �� si �� si-1 , vali = 1
//2.2 �� si = si-1 , vali = vali-1 + 1
//�ַ����ļ�ֵ���� val1 + val2 + val3 + ... + valn
//�����ɾ�� s ��������ַ����������������ֵ�Ƕ��١�
public class StrValue {
    public static int StrValue(String str){
        int n=str.length();
        int[]sum=new int[n];
        sum[0]=1;
        for(int i=1;i<n;i++){
            sum[i]=sum[i-1]+1;
            int match=1;
            for(int j=i-1;j>=0;j--){
                if(str.charAt(i)==str.charAt(j))
                    match++;
                else
                    sum[i]=Math.max(sum[i],sum[j]+(match*(match+1))/2);
            }
            sum[i]=Math.max(sum[i],(match*(match+1))/2);
        }
        return sum[n-1];
    }

    public static void main(String[] args) {
        String str="11111000111011101100";
        System.out.print(StrValue(str));
    }
}
