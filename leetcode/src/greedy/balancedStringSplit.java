package greedy;
//��һ��ƽ���ַ����У�'L'��'R'�ַ�����������ͬ�ġ�����һ��ƽ���ַ���s�����㽫���ָ�ɾ����ܶ��ƽ���ַ�����
public class balancedStringSplit {
    public static int balancedStringSplit(String str){
        int cnt=0,left=0,right=0;
        for(char ch:str.toCharArray()){
            if(ch=='L')
                left++;
            else
                right++;
            if(left==right)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String str="LRLLRLRR";
        System.out.println(balancedStringSplit(str));

    }
}
