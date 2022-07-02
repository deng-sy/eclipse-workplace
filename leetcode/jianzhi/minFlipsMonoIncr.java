package jianzhi;

public class minFlipsMonoIncr {
    public int minFlipsMonoIncr(String s) {
        int n=s.length();
        int dp0=0,dp1=0;
        for(int i=0;i<n;i++){
            dp1=Math.min(dp0,dp1);
            if(s.charAt(i)=='0')
                dp1++;
            else
                dp0++;
        }
        return Math.min(dp0,dp1);
    }
}
