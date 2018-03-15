import java.util.Map;
import java.util.TreeMap;

public class CompressedTrie {
    public Map<String, CompressedTrie> children;
    public CompressedTrie() {
        children = new TreeMap<String, CompressedTrie>();
    }
    public static CompressedTrie compressTrie(Trie t) {
        //have the value of String trie and add to children
        CompressedTrie c = new CompressedTrie();
        char[] set = new char[27];
        c.children.put(t.s + '{', c);

        System.out.println();
        System.out.println(c.children.toString());

        return c;
    }
    public boolean query(String s) {
	return false;
    }
    public void insert(String s) {
    }
}
