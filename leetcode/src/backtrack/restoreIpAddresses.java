package backtrack;
import javax.imageio.stream.ImageInputStream;
import java.util.*;
//��Ч IP ��ַ �������ĸ�������ÿ������λ�� 0 �� 255 ֮����ɣ��Ҳ��ܺ���ǰ�� 0��������֮���� '.' �ָ���
//
//���磺"0.1.2.201" �� "192.168.1.1" �� ��Ч IP ��ַ������ "0.011.255.245"��"192.168.1.312" �� "192.168@1.1" �� ��Ч IP ��ַ��
//����һ��ֻ�������ֵ��ַ��� s �����Ա�ʾһ�� IP ��ַ���������п��ܵ���Ч IP ��ַ����Щ��ַ����ͨ���� s �в���?'.' ���γɡ��� ����?���������ɾ�� s �е��κ����֡�����԰� �κ� ˳�򷵻ش𰸡�

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
