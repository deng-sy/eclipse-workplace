package hard;
//��������ַ���?X �е�������ͬλ�õ���ĸ��ʹ�������ַ���?Y ��ȣ���ô�� X �� Y �����ַ������ơ�����������ַ�����������ȵģ�������Ҳ�����Ƶġ�
//���磬"tars" �� "rats" �����Ƶ� (���� 0 �� 2 ��λ��)��?"rats" �� "arts" Ҳ�����Ƶģ����� "star" ���� "tars"��"rats"���� "arts" ���ơ�
//��֮������ͨ���������γ������������飺{"tars", "rats", "arts"} �� {"star"}��ע�⣬"tars" �� "arts" ����ͬһ���У���ʹ���ǲ������ơ���ʽ�ϣ���ÿ������ԣ�Ҫȷ��һ�����������У�ֻ��Ҫ����ʺ͸���������һ���������ơ�
//����һ���ַ����б� strs���б��е�ÿ���ַ������� strs �����������ַ�����һ��?��ĸ��λ��?������ strs ���ж��ٸ������ַ����飿
//��ĸ��λ�ʣ�anagram����һ�ְ�ĳ���ַ�������ĸ��λ�ã�˳�򣩼��ԸĻ����γɵ��´ʡ�

public class numSimilarGroups {
    int[]f;
    public int numSimilarGroups(String[] strs) {
        int n=strs.length,m=strs[0].length();
        f=new int[n];
        for(int i=0;i<n;i++)
            f[i]=i;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int fi=find(i),fj=find(j);
                if(fi==fj)
                    continue;
                if(check(strs[i],strs[j]))
                    f[fi]=fj;
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(f[i]==i)
                ans++;
        }
        return ans;
    }
    private int find(int x){
        return f[x]==x?x:(f[x]=find(f[x]));
    }
    private boolean check(String str1,String str2){
        int gap=0;
        int n=str1.length();
        for(int i=0;i<n;i++){
            if(str1.charAt(i)!=str2.charAt(i))
                gap++;
            if(gap>2)
                return false;
        }
        return true;
    }
}
