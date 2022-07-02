package Graph;
//现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。
//给定一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。
//请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种 顺序即可。
import java.util.*;
public class alienOrder {
//    拓扑排序，通过入度来解决
    public static String alienOrder(String[] words) {
        String pre=words[0];
        int pre_len=pre.length(),cur_len,min_len;
        int idx;
        char pre_char,cur_char;
        int N=26;
        int[]indegs=new int[N];
        Arrays.fill(indegs,-1);
        List<List<Integer>>edges=new ArrayList<>();
        for(int i=0;i<N;i++){
            edges.add(new ArrayList<>());
        }
        for(String cur:words){
            cur_len=cur.length();
            min_len=Math.min(pre_len,cur_len);
            idx=0;
            while(idx<min_len){
                pre_char=pre.charAt(idx);
                cur_char=cur.charAt(idx);
                indegs[cur_char-'a']=indegs[cur_char-'a']==-1?0:indegs[cur_char-'a'];
                if(pre_char==cur_char){
                    idx++;
                    continue;
                }else{
                    indegs[cur_char-'a']++;
                    edges.get(pre_char-'a').add(cur_char-'a');
                    break;
                }
            }
            if(idx==cur_len&&idx<pre_len){
                return "";
            }

            while(idx<cur_len){
                cur_char=cur.charAt(idx++);
                indegs[cur_char-'a']=indegs[cur_char-'a']==-1?0:indegs[cur_char-'a'];
            }
            pre=cur;
            pre_len=cur_len;
        }
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<N;i++){
            if(indegs[i]==0){
                queue.offer(i);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!queue.isEmpty()){
            int i=queue.poll();
            sb.append((char)('a'+i));
            for(int j:edges.get(i)){
                indegs[j]--;
                if(indegs[j]==0){
                    queue.offer(j);
                }
            }
        }
        for(int indeg:indegs){
            if(indeg>0)
                return "";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[]words={"wrt","wrf","er","ett","rftt"};
//        String[]words={"z","x","a","zb","zx"};
        System.out.println(alienOrder(words));
    }
}
