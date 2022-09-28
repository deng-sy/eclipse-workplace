package huawei;

import java.util.*;

//����һ���ַ��� path ����ʾָ��ĳһ�ļ���Ŀ¼�� Unix ��� ����·�� ���� '/' ��ͷ�������㽫��ת��Ϊ���Ӽ��Ĺ淶·����
public class simplifyPath {
    public static String simplifyPath(String path) {
        String[]dirs=path.split("/");
        List<String>list=new ArrayList<>();
        for(String dir:dirs){
            switch (dir){
                case "..":
                    if(list.size()>0)
                        list.remove(list.size()-1);
                    break;
                case "":
                case ".":
                    break;
                default:
                    list.add(dir);
            }

        }
        if(list.isEmpty())
            return "/";
        StringBuilder sb=new StringBuilder();
        for(String dir:list){
            sb.append("/").append(dir);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
