package Tree;

//Trie����������" try "������˵ǰ׺����һ���������ݽṹ�����ڸ�Ч�ش洢�ͼ�����
//�������ݼ��еļ�����һ���ݽṹ���൱���Ӧ���龰�������Զ������ƴд��顣

class TrieNode {
    boolean isWord;
    TrieNode[]children;
    public TrieNode(){
        isWord=false;
        children=new TrieNode[26];
    }


}
