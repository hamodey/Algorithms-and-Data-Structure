public class RKStringMatch implements StringMatch {
    String pattern;
    String text;
    public int match(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        int n = text.length();
        int m = pattern.length();
        boolean found = true;
        int hm = hash(m);
        // printArray(textSp);
        // System.out.println();
        // printArray(patternSp);
        // System.out.println();

        for(int s = 0; s <= (n-m); s++){
            if(hash(text.charAt(s)) == hm){
                found = true;
                for(int j = 0; j < m; j++){
                    if(text.charAt(s+j) != pattern.charAt(j)){
                        found = false;
                        break;
                    }
                }
                if(found){
                    return s;
                }
            }
        }
        return -1;
    }

    private int hash(int m2){
        int sum = 0;
        for(int k = m2; k < (m2+k-1); k++){
            sum = (sum + pattern.charAt(k)) % 256;
        }
        return sum;
    }

}
