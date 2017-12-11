public interface StringMatch {
    public OpCounter counter = new OpCounter();
    public int match(String text, String pattern);
    //{
    //     if(pattern.isEmpty()){
    //         return 0;
    //     }
    //     int m = pattern.length();
    //     int n = text.length();
    //     if(m > n){
    //         return -1;
    //     }
    //     for(int s = 0; s <= text.length-m; s++){
    //         if(text[s] == pattern[m]){
    //             return s;
    //         }
    //     }
    //     return false;
    // }
}
