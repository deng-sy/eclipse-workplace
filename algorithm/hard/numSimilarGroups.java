package hard;
//如果交换字符串?X 中的两个不同位置的字母，使得它和字符串?Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
//例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)；?"rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
//总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
//给定一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个?字母异位词?。请问 strs 中有多少个相似字符串组？
//字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。

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
