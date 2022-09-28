package hard;
import java.util.*;
//���ֵ䣨�����б�?wordList �У��ӵ��� beginWord?�� endWord �� ת������ ��һ������������γɵ����У�
//�����е�һ�������� beginWord ��
//���������һ�������� endWord ��
//ÿ��ת��ֻ�ܸı�һ����ĸ��
//ת�������е��м䵥�ʱ������ֵ�?wordList �еĵ��ʡ�
//��������������ͬ�����ݲ�ͬ�ĵ��� beginWord?�� endWord ��һ���ֵ� wordList ���ҵ���?beginWord ��?endWord �� ���ת������ �е� ������Ŀ �����������������ת�����У����� 0��

public class ladderLength {
    List<List<Integer>>edges=new ArrayList<>();
    Map<String,Integer>ids=new HashMap<>();
    int num=0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String word:wordList){
            addEdge(word);
        }
        addEdge(beginWord);
        if(!ids.containsKey(endWord))
            return 0;
        int[]distBegin=new int[num],distEnd=new int[num];
        Arrays.fill(distBegin,Integer.MAX_VALUE);
        Arrays.fill(distEnd,Integer.MAX_VALUE);
        int begin=ids.get(beginWord),end=ids.get(endWord);
        distBegin[begin]=0;
        distEnd[end]=0;

        Queue<Integer>queueBegin=new LinkedList<>(),queueEnd=new LinkedList<>();
        queueBegin.offer(begin);
        queueEnd.offer(end);
        while(!queueBegin.isEmpty()&&!queueEnd.isEmpty()){
            int beginSize=queueBegin.size();
            for(int i=0;i<beginSize;i++){
                int x=queueBegin.poll();
                if(distEnd[x]!=Integer.MAX_VALUE){
                    return (distEnd[x]+distBegin[x])/2+1;
                }
                for(int id: edges.get(x)){
                    if(distBegin[id]==Integer.MAX_VALUE){
                        distBegin[id]=distBegin[x]+1;
                        queueBegin.offer(id);
                    }
                }
            }
            int endSize=queueEnd.size();
            for(int i=0;i<endSize;i++){
                int y=queueEnd.poll();
                if(distBegin[y]!=Integer.MAX_VALUE){
                    return (distEnd[y]+distBegin[y])/2+1;
                }
                for(int id: edges.get(y)){
                    if(distEnd[id]==Integer.MAX_VALUE){
                        distEnd[id]=distEnd[y]+1;
                        queueEnd.offer(id);
                    }
                }
            }

        }
        return 0;
    }
    private void addWord(String word){
        if(!ids.containsKey(word)){
            ids.put(word,num++);
            edges.add(new ArrayList<>());
        }
    }
    private void addEdge(String word){
//       �������ڵ�
        addWord(word);
        int id1=ids.get(word);
        char[]arr=word.toCharArray();
        for(int i=0;i<arr.length;i++){
            char tmp=arr[i];
            arr[i]='*';
            String newWord=new String(arr);
            addWord(newWord);
            int id2=ids.get(newWord);
            edges.get(id1).add(id2);
            edges.get(id2).add(id1);
            arr[i]=tmp;
        }
    }
}
