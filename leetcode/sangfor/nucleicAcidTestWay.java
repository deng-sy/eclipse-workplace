package sangfor;

public class nucleicAcidTestWay {
    public int nucleicAcidTestWay(int n) {
        // write code here
        int zero = 0, one = 1;
        for (int i = 1; i < n; i++) {
            int tmp = zero;
            zero = one;
            one += tmp;
        }
        return one + zero;
    }
}
