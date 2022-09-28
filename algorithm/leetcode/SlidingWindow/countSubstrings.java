package SlidingWindow;

public class countSubstrings {
    public int countSubstrings(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=span(s,i,i);
            ans+=span(s,i,i+1);
        }
        return ans;

    }
    private int span(String s,int i,int j){
        int n=s.length();
        int ans=0;
        while(i>=0&&j<n){
            if(s.charAt(i)==s.charAt(j)){
                ans++;
                i--;
                j++;
            }else
                break;
        }
        return ans;
    }
}
