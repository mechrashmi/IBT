/**
 * Created by rashmimech on 1/31/17.
 */
public class implementStrStr {
    public static void main(String[] args) {
        implementStrStr test = new implementStrStr();

        System.out.println(test.strStr("bbabaaababbbaabaaaba", "babaaa"));
    }
    public int strStr(final String haystack, final String needle) {
        if(needle.isEmpty() || haystack.isEmpty()) return -1;
        int e = 0;
        for(int i = 0; i < haystack.length(); i++){
            if(e == needle.length()){
                return i - needle.length();
            }

            if(needle.charAt(e) == haystack.charAt(i)){
                e++;
            }
            else{
                if(needle.charAt(0) == haystack.charAt(i)){
                    e = 1;
                }
                else {
                    e = 0;
                }
            }

        }

        if(e == needle.length()){
            return haystack.length() - needle.length();
        }

        return -1;

    }
}
