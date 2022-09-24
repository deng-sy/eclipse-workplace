package zhousai;

import java.util.Arrays;

//6185. 运动员和训练师的最大匹配数
public class matchPlayersAndTrainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int p = players.length, t = trainers.length;
        int ans = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0, j = 0;
        while (i < p && j < t) {
            if (players[i] <= trainers[j]) {
                ans++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return ans;
    }
//    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
//        int p = players.length, t = trainers.length;
//        int[] match = new int[t];
//        boolean[] used = new boolean[t];
//        Arrays.fill(match, -1);
//        int ans = 0;
//        for (int i = 0; i < p; i++) {
//            Arrays.fill(used, false);
//            if (find(match, used, players, trainers, i))
//                ans++;
//        }
//        return ans;
//    }

    boolean find(int[] match, boolean[] used, int[] players, int[] trainers, int i) {
        for (int j = 0; j < trainers.length; j++) {
            if (trainers[j] >= players[i] && !used[j]) {
                used[j] = true;
                if (match[j] == -1 || find(match, used, players, trainers, match[j])) {
                    match[j] = i;
                    return true;
                }
            }
        }
        return false;
    }
}
