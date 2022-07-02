package didi;
import java.util.*;
public class CIDR {
    static class Addr{
        String addrStr;
        int mask;
        int addr;
        public Addr(String addrStr, int mask, int addr) {
            this.addrStr = addrStr;
            this.mask = mask;
            this.addr = addr;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            List<Addr>list=new LinkedList<>();
            while(n-->0){
                String addrStr=sc.next();
                String[]strs=addrStr.split("/");
                int mask=Integer.valueOf(strs[1]);
                strs=strs[0].split("\\.");
                int addr=(Integer.valueOf(strs[0])<<24)|(Integer.valueOf(strs[1])<<16)|(Integer.valueOf(strs[2])<<8)|(Integer.valueOf(strs[3]));
                boolean flag=true;
                for(Iterator<Addr>it=list.iterator();it.hasNext();){
                    Addr tmp=it.next();
                    if(mask<tmp.mask&&(addr^tmp.addr)>>>(32-mask)==0)
                        it.remove();
                    if(mask>=tmp.mask&&(addr^tmp.addr)>>>(32-tmp.mask)==0){
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    list.add(new Addr(addrStr,mask,addr));
                System.out.println(list.size());

            }
            for(Iterator<Addr>it=list.iterator();it.hasNext();){
                Addr tmp=it.next();
                System.out.println(tmp.addrStr);
            }

        }
    }
}
