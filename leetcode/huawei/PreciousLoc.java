package huawei;
import java.util.*;
public class PreciousLoc {
    static char[][]map;
    static int x,y,k;
    static int n,m;
    static List<Integer>list=new ArrayList<>();
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        n=sc.nextInt();
//        m=sc.nextInt();
//        map=new char[n][m];
//        for(int i=0;i<n;i++){
//            String str=sc.next();
//            for(int j=0;j<m;j++){
//                map[i][j]=str.charAt(j);
//            }
//        }
////        System.out.println(Arrays.deepToString(map));
//        x=sc.nextInt();
//        y=sc.nextInt();
//        k=sc.nextInt();
        n=2;
        m=3;
        map=new char[n][m];
        String[]str={">>v","^<<"};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=str[i].charAt(j);
            }
        }
        x=0;
        y=0;
        k=123;
        getResult();

    }
    private static void getResult(){
        int i=0;
        while(i++<k){
//            System.out.println(i+":"+"("+x+","+y+")"+(x*m+y));
            if(list.contains(x*m+y)){
                int first_loc=list.indexOf(x*m+y);
                int loop=i-1-first_loc;
//                System.out.println(loop);
                int final_loc=list.get((k-first_loc)%loop+first_loc);
                x=final_loc/m;
                y=final_loc%m;
                break;
            }
            list.add(x*m+y);

            if(map[x][y]=='<'){
                if(y-1<0||map[x][y-1]=='#')
                    break;
                y--;
            }else if(map[x][y]=='>'){
                if(y+1==m||map[x][y+1]=='#')
                    break;
                y++;
            }else if(map[x][y]=='^'){
                if(x-1<0||map[x-1][y]=='#')
                    break;
                x--;
            }else if(map[x][y]=='v'){
                if(x+1==n||map[x+1][y]=='#')
                    break;
                x++;
            }else if(map[x][y]=='.'){
                break;
            }

        }

        System.out.println(x+" "+y);
    }

}
