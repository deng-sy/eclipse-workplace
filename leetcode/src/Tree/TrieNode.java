package Tree;

//Trie（发音类似" try "）或者说前缀树是一种树形数据结构，用于高效地存储和检索字
//符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

class TrieNode {
    boolean isWord;
    TrieNode[]children;
    public TrieNode(){
        isWord=false;
        children=new TrieNode[26];
    }


}
