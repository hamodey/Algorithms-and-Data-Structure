public class NaiveStringMatch implements StringMatch {
    public int match(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        boolean found = true;
        // printArray(textSp);
        // System.out.println();
        // printArray(patternSp);
        // System.out.println();

        for(int s = 0; s <= (n-m); s++){
            found = true;
            //System.out.println(s);
            for(int j = 0; j < m; j++){
                if(text.charAt(s+j) != pattern.charAt(j)){
                    found = false;
                    break;
                }else{
                    found = true;
                }
            }
            if(found == true){
                System.out.println(text + " " + pattern + " " + s);

                return s;
            }
        }
        return -1;
     }
}
