public class Trie {
    char c;
    public Trie[] children;
    public boolean isWord;
    public String s;
    public Trie() {
        this.children = new Trie[27];
        isWord = false;
    }
    public void insert(String s) {
        //add the letters to children to newT
        //newT.children.append letters
        this.s = s;
        if(s.isEmpty()){
            this.isWord = true;
            this.children[26] = new Trie();
            return;
        }
        char letter = s.charAt(0);
        // System.out.println("letter " + letter);
        int index = letter - 'a';
        // System.out.println("idx" + index);
        if(this.children[index] == null){
            this.children[index] = new Trie();
            this.children[index].c = letter;
        }
        this.children[index].insert(s.substring(1));

    }

    public boolean query(String s) {
        if(s.isEmpty()) return this.isWord;

        int idx = s.charAt(0) - 'a';

        if(this.children[idx] == null){
            return false;
        }

        return this.children[idx].query(s.substring(1));
    }

}
