package huawei;

import java.util.*;

//给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
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
