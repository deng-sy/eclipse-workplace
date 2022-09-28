package BFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//����һ������������2-9���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰�����˳
//�򷵻ء��������ֵ���ĸ��ӳ�����£���绰������ͬ����ע��1����Ӧ�κ���ĸ��
public class letterCombinations {

//    ������Ƚ����bfs)
    public static List<String>letterCombinations_BFS(String digits){
        LinkedList<String>res=new LinkedList<>();
        if(digits==null||digits.isEmpty())
            return res;
        char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        res.add("");
        while(res.peek().length()!=digits.length()){
            String remove=res.poll();
//            System.out.println(remove.length())-'2');
            char[]chars=tab[digits.charAt(remove.length())-'2'];
            System.out.println(Arrays.toString(chars));
            for(int i=0;i<chars.length;i++)
                res.add(remove+chars[i]);
            System.out.println(res);
        }
        return res;
    }

//    ������Ƚ����dfs)
    public static List<String>letterCombinations_DFS(String digits){
    LinkedList<String>res=new LinkedList<>();
    if(digits==null||digits.isEmpty())
        return res;
    char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    dfs(res,0,digits,tab,"");
    return res;
}

    public static void dfs(List<String>res,int idx,String digits,char[][]tab,String path){
        if(path.length()==digits.length()){
            res.add(path);
            return;
        }
        char[]chars=tab[digits.charAt(idx)-'2'];
        for(int i=0;i<chars.length;i++)
            dfs(res,idx+1,digits,tab,path+chars[i]);
    }
    public static void main(String[] args) {
        String digits="23";
        System.out.println(letterCombinations_DFS(digits));
    }
}
