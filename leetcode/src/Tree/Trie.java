package Tree;

public class Trie {
    private TrieNode root;
    public Trie(){
        root=new TrieNode();
    }
    public void insert(String word){
        TrieNode parent=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(parent.children[idx]==null)
                parent.children[idx]=new TrieNode();
            parent=parent.children[idx];
        }
        parent.isWord=true;
    }

    public boolean startsWith(String prefix){
        return find(prefix)!=null;
    }
    private TrieNode find(String str){
        TrieNode parent=root;
        int len=str.length();
        for(int i=0;i<len;i++){
            int idx=str.charAt(i)-'a';
            if((parent=parent.children[idx])==null)
                return null;
        }
        return parent;
    }

    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("apple");
        System.out.println(trie.startsWith("app"));
    }
}
