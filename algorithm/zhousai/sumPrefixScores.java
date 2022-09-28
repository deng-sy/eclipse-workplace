package zhousai;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.Arrays;
import java.util.HashMap;

public class sumPrefixScores {
    class TrieNode {
        TrieNode[] children;
        Set<Integer> set;

        public TrieNode() {
            children = new TrieNode[26];
            set = new HashSet<>();
        }
    }

    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] ans = new int[n];
        TrieNode root = new TrieNode();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new TrieNode();
                }
                cur.children[ch - 'a'].set.add(i);
                cur = cur.children[ch - 'a'];
            }
        }
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TrieNode parent = queue.poll();
            for (TrieNode child : parent.children) {
                if(child==null)
                    continue;
                queue.offer(child);
                for (int i : child.set) {
                    ans[i] += child.set.size();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "ab", "bc", "b"};
        System.out.println(Arrays.toString(new sumPrefixScores().sumPrefixScores(words)));
    }
}
