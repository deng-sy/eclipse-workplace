package BitOperation;

public class binaryGap {
    public static int binaryGap(int n) {
        int cur=0,pre=-1;
        int maxGap=0;
        while(n>0){
            int mod=n%2;
            n/=2;
            if(mod==1){
                if(pre==-1)
                    pre=cur;
                maxGap=Math.max(maxGap,cur-pre);
                pre=cur;
            }
            cur++;
        }
        return maxGap;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(5));
    }
}
