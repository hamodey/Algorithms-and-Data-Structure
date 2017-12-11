public interface StringMatch {
    public OpCounter counter = new OpCounter();
    public int match(String text, String pattern);
}
