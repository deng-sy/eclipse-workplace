package Graph;
//����һ��ʹ��Ӣ����ĸ�����������ԣ��������Ե���ĸ˳����Ӣ��˳��ͬ��
//����һ���ַ����б� words ����Ϊ�������ԵĴʵ䣬words �е��ַ����Ѿ� �����������Ե���ĸ˳����������� ��
//������ݸôʵ仹ԭ������������֪����ĸ˳�򣬲� ����ĸ����˳�� ���С��������ںϷ���ĸ˳�򣬷��� "" �������ڶ��ֿ��ܵĺϷ���ĸ˳�򣬷������� ����һ�� ˳�򼴿ɡ�
import java.util.*;
public class alienOrder {
//    ��������ͨ����������
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
