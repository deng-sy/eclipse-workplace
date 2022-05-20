package huawei;

public class longestCommonSubstring {
    public static void main(String[] args) {
        String s1="addbbccaacbddbbb";
        String s2="ddcddcbcdbcbbbdabdcddabddcadbbbbdddabacaadcdcaacd";
        int res=0;
        int start=0,end=0;
        for(int i=0;i<s2.length();i++){
            for(int j=s2.length();j>i;j--){
                if(s1.contains(s2.substring(i,j))){
                    if(res<j-i){
                        res=j-i;
                        start=i;
                        end=j;
                        break;
                    }

                }
            }
//            if(res!=0)
//                break;
        }
        System.out.println(res);
        System.out.println(s2.substring(start,end));
    }
}
