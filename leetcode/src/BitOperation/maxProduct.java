package BitOperation;
//给定一个字符串数组?words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。

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

