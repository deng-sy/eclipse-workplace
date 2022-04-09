package backtrack;
import javax.imageio.stream.ImageInputStream;
import java.util.*;
//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
//例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
//给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入?'.' 来形成。你 不能?重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。

public class restoreIpAddresses {
    List<String>res=new ArrayList<>();
    int len;
    int[]segments=new int[4];
    public List<String> restoreIpAddresses(String s) {
        len=s.length();
//        int[]map=new int[len];
//        Arrays.fill(map,-1)
        backtrack(s,0,0);
        return res;

    }
    private void backtrack(String s,int segId,int segStart){
        if(segId==4){
            System.out.println(Arrays.toString(segments));
            if(segStart==len){

                StringBuffer sb=new StringBuffer();
                for(int i=0;i<4;i++){
                    sb.append(segments[i]);
                    if(i!=3)
                        sb.append('.');
                }
                res.add(sb.toString());
            }
            return;
        }
        if(segStart==len)
            return;
        if(s.charAt(segStart)=='0'){
            segments[segId]=0;
            backtrack(s,segId+1,segStart+1);


        }
        int addr=0;
        for(int segEnd=segStart;segEnd<len;segEnd++){
            addr=addr*10+(s.charAt(segEnd)-'0');

            if(addr>0&&addr<=0xFF){
//                System.out.print(addr+" ");
                segments[segId]=addr;
                backtrack(s,segId+1,segEnd+1);
            }else
                break;
        }



    }

    public static void main(String[] args) {
        restoreIpAddresses restoreIpAddresses=new restoreIpAddresses();
        System.out.print(restoreIpAddresses.restoreIpAddresses("101023"));
    }
}
