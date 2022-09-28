package backtrack;

import java.util.List;

class hanota {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(),A,B,C);
    }
    private void move(int size,List<Integer> A, List<Integer> B, List<Integer> C){
        if(size==1){
            C.add(A.remove(A.size()-1));
            return;
        }
        move(size-1,A,B,C);
        C.add(A.remove(A.size()-1));
        move(size-1,B,A,C);

    }
}