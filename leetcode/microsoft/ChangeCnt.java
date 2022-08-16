package microsoft;

public class ChangeCnt {
    public int solution(String S) {
        int max=1000000000;
        int ans=0;
        int n=S.length();
        int[]pos=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            char ch=S.charAt(i);
            if(ch=='R'){
                pos[cnt++]=i;
            }
        }
        int mid=cnt/2;
        for(int i=0;i<mid;i++){
            ans+=(pos[mid]-mid+i-pos[i]);
            if(ans>max)
                return -1;
        }
        for(int i=cnt-1;i>mid;i--){
            ans+=(pos[i]-(pos[mid]+i-mid));
            if(ans>max)
                return -1;
        }
        return ans;

    }

    public static void main(String[] args) {
        String S="WRRWWR";
        System.out.println(new ChangeCnt().solution(S));
    }

}
