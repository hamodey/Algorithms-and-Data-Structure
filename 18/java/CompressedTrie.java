import java.util.Map;
import java.util.HashMap;

public class CompressedTrie {
    public Map<String, CompressedTrie> children;
    public CompressedTrie() {
        children = new HashMap<String, CompressedTrie>();
    }
    public static CompressedTrie compressTrie(Trie t) {
        //have the value of String trie and add to children
        CompressedTrie c = new CompressedTrie();
        int len = t.children.length;

        for(int i = 0 ; i < len; i ++){
            // System.out.println(t.s);
            c.children.put(t.s + '{', c);

        }
        return c;
    }
    public boolean query(String s) {
	return false;
    }
    public void insert(String s) {
    }
}
