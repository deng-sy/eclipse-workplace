package BitOperation;
//����һ���ַ�������?words������㵱�����ַ��� words[i] �� words[j] ��������ͬ�ַ�ʱ�����ǳ��ȵĳ˻������ֵ�������ַ�����ֻ����Ӣ���Сд��ĸ�����û�в�������ͬ�ַ���һ���ַ��������� 0��

public class maxProduct {
    public int maxProduct(String[] words) {
        int res=0;
        String word;
        int[]mask=new int[words.length];
        for(int i=0;i<words.length;i++){
            word=words[i];
            for(int j=0;j<word.length();j++){
                mask[i]|=1<<(word.charAt(j)-'a');
            }
        }
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((mask[i]&mask[j])==0){
                    res=Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}

