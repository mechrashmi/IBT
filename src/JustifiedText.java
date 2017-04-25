import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rashmimech on 4/1/17.
 Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 You should pack your words in a greedy approach; that is, pack as many words as you can in each line.

 Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
 Extra spaces between words should be distributed as evenly as possible.
 If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 For the last line of text, it should be left justified and no extra space is inserted between words.

 Your program should return a list of strings, where each string represents a single line.

 Example:

 words: ["This", "is", "an", "example", "of", "text", "justification."]

 L: 16.

 Return the formatted lines as:

 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Note: Each word is guaranteed not to exceed L in length.

 */

public class JustifiedText {
    public static void main(String[] args) {
        //String[] list = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        //String[] list = new String[]{""};
       // String[] list = new String[]{"glu", "muskzjyen", "ahxkp", "t", "djmgzzyh", "jzudvh", "raji", "vmipiz", "sg", "rv", "mekoexzfmq", "fsrihvdnt", "yvnppem", "gidia", "fxjlzekp", "uvdaj", "ua", "pzagn", "bjffryz", "nkdd", "osrownxj", "fvluvpdj", "kkrpr", "khp", "eef", "aogrl", "gqfwfnaen", "qhujt", "vabjsmj", "ji", "f", "opihimudj", "awi", "jyjlyfavbg", "tqxupaaknt", "dvqxay", "ny", "ezxsvmqk", "ncsckq", "nzlce", "cxzdirg", "dnmaxql", "bhrgyuyc", "qtqt", "yka", "wkjriv", "xyfoxfcqzb", "fttsfs", "m"};
       // String[] list = new String[]{"zoea", "cmdw", "l", "bxcyofzw", "jwzr", "kwjpyevjxq", "queigj", "xf", "abighmqbtf", "txjysly", "fqcxvxokgm", "uc", "fefqtpkd", "ctbv", "pmgrbggjq", "henz", "zubxjlxodp", "yhxhl", "rii", "rxribedfv", "tywrhilgsb", "xz"};
        String[] list = new String[]{"am", "fasgoprn", "lvqsrjylg", "rzuslwan", "xlaui", "tnzegzuzn", "kuiwdc", "fofjkkkm", "ssqjig", "tcmejefj", "uixgzm", "lyuxeaxsg", "iqiyip", "msv", "uurcazjc", "earsrvrq", "qlq", "lxrtzkjpg", "jkxymjus", "mvornwza", "zty", "q", "nsecqphjy"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(list));

        //ArrayList<String> res = new JustifiedText().fullJustify(arrayList, 16);
        //ArrayList<String> res = new JustifiedText().fullJustify(arrayList, 144);
        //ArrayList<String> res = new JustifiedText().fullJustify(arrayList, 36);
        ArrayList<String> res = new JustifiedText().fullJustify(arrayList, 14);

        for (String line : res){
            System.out.println(line);
        }

    }


    public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
        int totalChars = 0;
        int linesRequired = 1;
        int actualchars = 0;
        for(int i = 0; i < a.size(); i++){
            totalChars += a.get(i).length();
            actualchars += a.get(i).length();
            if(totalChars > b){
                linesRequired++;
                totalChars = a.get(i).length();
            }
            totalChars++; //for space
        }

        //int linesRequired = (int) Math.ceil((float)totalChars / b);

        ArrayList<StringBuilder> resSB = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();

        if(actualchars == 0){
            return res;
        }

        int j = 0;
        for (int i = 0; i < linesRequired; i++){
            resSB.add(new StringBuilder());

            for(; j < a.size(); j++){
                int currLen = resSB.get(i).length();
                int nextLen = currLen == 0 ? currLen + a.get(j).length() : currLen + a.get(j).length() + 1;

                if(nextLen > b){
                    break;
                }

                if(resSB.get(i).length() == 0){
                    resSB.get(i).append(a.get(j));
                }
                else
                {
                    resSB.get(i).append(" " + a.get(j));
                }
            }
        }

        for(int i = 0; i < resSB.size() - 1; i++){
            StringBuilder line = resSB.get(i);
            int currLen = line.length();
            if(currLen != b){
                int lenNeedToAppend = b - currLen;
                int spaces = line.toString().split(" ").length - 1;
                if(spaces == 0){
                    while (lenNeedToAppend > 0){
                        line.append(' ');
                        lenNeedToAppend--;
                    }
                    continue;
                }
                int minspace = lenNeedToAppend / spaces;
                int lastIndex = 0;
                for(int k = 0; k < line.length(); k++){
                    lastIndex = line.indexOf(" ", lastIndex + 1);
                    int addSpace = minspace;
                    if(lastIndex != -1) {
                        while (addSpace > 0) {
                            line.insert(lastIndex + 1, ' ');
                            addSpace--;
                            lastIndex++;
                        }
                    }

                    if(lastIndex == -1) break;
                }

                lastIndex = 0;
                if(lenNeedToAppend % spaces != 0){
                    int moreSpace = b - line.length();
                    while (moreSpace > 0){
                        lastIndex = line.indexOf(" ", lastIndex + 1);
                        lastIndex++;
                        while(line.charAt(lastIndex) == ' '){
                            lastIndex++;
                        }
                        line.insert(lastIndex, ' ');
                        moreSpace--;
                        lastIndex++;
                    }
                }
            }
        }

        StringBuilder lastLine = resSB.get(resSB.size() - 1);
        if(lastLine.length() < b){
            int reqspaces = b - lastLine.length();
            while(reqspaces > 0){
                lastLine.append(' ');
                reqspaces--;
            }
        }



        for(int i = 0; i < resSB.size(); i++){
            res.add(resSB.get(i).toString());
        }

        return res;
    }
}
