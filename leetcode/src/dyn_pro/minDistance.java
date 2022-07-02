package dyn_pro;

class minDistance {
    public int minDistance(String word1, String word2) {
        int len1=word1.length(),len2=word2.length();
        if(len1*len2==0)
            return len1+len2;
        int[]dp=new int[len2+1];
        for(int i=0;i<=len2;i++)
            dp[i]=i;
        int last;//记录左上角的值
        for(int i=1;i<=len1;i++){
            last=dp[0];
            dp[0]=i;
            for(int j=1;j<=len2;j++){
                int tmp=dp[j];
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[j]=last;
                else
                    dp[j]=Math.min(Math.min(dp[j-1],dp[j]),last)+1;
                    //分别表示删除、增加、修改

                last=tmp;
            }
        }
        return dp[len2];

    }
}