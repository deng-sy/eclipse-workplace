package Nums_String;

class strStr {
    public static int strStr(String hh, String nn) {
    	
//    	KMP�㷨
        char[] haystack=hh.toCharArray();
        char[] needle=nn.toCharArray();
        int h=haystack.length;
        int n=needle.length;
        if(n==0){
            return 0;
        }

        int[] next=new int[n];
        
//        ����next����
        for(int i=1,j=0;i<n-1;i++){
            while(j>0&&needle[i]!=needle[j]){
                j=next[j];
            }
           
            if(needle[i]==needle[j]){
                j++;
            }
            next[i+1]=j;
           
        }
        
//        for(int i=0;i<next.length;i++) {
//        	System.out.print(next[i]);
//        }

        for(int i=0,j=0;i<h;i++){
            while(j>0&&haystack[i]!=needle[j]){
                j=next[j];
            }
            if(haystack[i]==needle[j]){
                j++;
            }
            if(j==n){
                return i-n+1;
            }
        }
        return -1;

    }
    
    public static void main(String[] args) {
    	int result=strStr("aabaaabaaac", "aabaaac");
		System.out.println(result);
	}
}