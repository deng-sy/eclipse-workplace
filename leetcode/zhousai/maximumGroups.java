package zhousai;

public class maximumGroups {
    public int maximumGroups(int[] grades) {
        int n=grades.length;
        int i=1;
        int ans=0;
        while(n>=i){
            ans++;
            n-=i;
            i++;
        }
        return ans;
    }


}
